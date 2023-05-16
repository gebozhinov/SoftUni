package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.post.PostImportWrapper;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import static softuni.exam.instagraphlite.constant.Message.INVALID_DATA;
import static softuni.exam.instagraphlite.constant.Message.SUCCESSFULLY_IMPORTED_POST;
import static softuni.exam.instagraphlite.constant.Paths.IMPORT_POSTS_PATH;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final PictureRepository pictureRepository;

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public PostServiceImpl(PostRepository postRepository,
                           PictureRepository pictureRepository,
                           UserRepository userRepository,
                           ModelMapper modelMapper,
                           ValidationUtils validationUtils) {
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(IMPORT_POSTS_PATH);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_POSTS_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(PostImportWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PostImportWrapper unmarshal = (PostImportWrapper) unmarshaller.unmarshal(file);
        unmarshal.getPosts()
                .forEach(postImportDTO -> {
                    boolean isValid = validationUtils.isValid(postImportDTO);

                    Optional<Picture> picture =
                            pictureRepository.findFirstByPath(postImportDTO.getPicture().getPath());
                    Optional<User> user =
                            userRepository.findFirstByUsername(postImportDTO.getUser().getUsername());

                    if (picture.isEmpty() || user.isEmpty()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Post post = modelMapper.map(postImportDTO, Post.class);
                        post.setPicture(picture.get());
                        post.setUser(user.get());
                        postRepository.saveAndFlush(post);

                        sb.append(String.format(SUCCESSFULLY_IMPORTED_POST, post.getUser().getUsername()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "Post"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
