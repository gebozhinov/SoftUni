package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.user.UserImportDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static softuni.exam.instagraphlite.constant.Message.INVALID_DATA;
import static softuni.exam.instagraphlite.constant.Message.SUCCESSFULLY_IMPORTED_USER;
import static softuni.exam.instagraphlite.constant.Paths.IMPORT_USERS_PATH;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_INFO = "User: %s%n" +
            "Post count: %d%n";
    private static final String POST_INFO = "==Post Details:%n" +
            "----Caption: %s%n" +
            "----Picture Size: %.2f%n";
    private final UserRepository userRepository;

    private final PictureRepository pictureRepository;
    private final Gson gson;

    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public UserServiceImpl(UserRepository userRepository,
                           PictureRepository pictureRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(IMPORT_USERS_PATH);
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), UserImportDTO[].class))
                .forEach(userImportDTO -> {
                    boolean isValid = validationUtils.isValid(userImportDTO);

                    Optional<Picture> picture =
                            pictureRepository.findFirstByPath(userImportDTO.getProfilePicture());

                    if (picture.isEmpty() ||
                            userRepository.findFirstByUsername(userImportDTO.getUsername()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        User user = modelMapper.map(userImportDTO, User.class);
                        user.setProfilePicture(picture.get());
                        userRepository.saveAndFlush(user);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_USER, user.getUsername()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "User"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        List<User> users = userRepository.usersWithPosts().orElseThrow(NoSuchElementException::new);

        List<User> sorted = new ArrayList<>();

        for (User user : users) {
            List<Post> posts = user.getPosts().stream()
                    .sorted(Comparator.comparing(s -> s.getPicture().getSize()))
                    .toList();
            user.setPosts(posts);
            sorted.add(user);
        }

        StringBuilder sb = new StringBuilder();
        for (User user : sorted) {
            sb.append(String.format(USER_INFO, user.getUsername(), user.getPosts().size()));
            for (Post post : user.getPosts()) {
                sb.append(String.format(POST_INFO, post.getCaption(), post.getPicture().getSize()));
            }
        }
        return sb.toString().trim();
    }
}
