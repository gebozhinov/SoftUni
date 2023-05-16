package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.picture.PictureImportDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static softuni.exam.instagraphlite.constant.Message.INVALID_DATA;
import static softuni.exam.instagraphlite.constant.Message.SUCCESSFULLY_IMPORTED_PICTURE;
import static softuni.exam.instagraphlite.constant.Paths.IMPORT_PICTURES_PATH;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PRINT_OUTPUT = "%.2f – %s%n";
    private final PictureRepository pictureRepository;
    private final Gson gson;

    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    public PictureServiceImpl(PictureRepository pictureRepository,
                              Gson gson,
                              ModelMapper modelMapper,
                              ValidationUtils validationUtils) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(IMPORT_PICTURES_PATH);
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), PictureImportDTO[].class))
                .forEach(pictureImportDTO -> {
                    boolean isValid = validationUtils.isValid(pictureImportDTO);

                    if (pictureRepository.findFirstByPath(pictureImportDTO.getPath()).isPresent()) {
                        isValid = false;
                    }

                    if (isValid) {
                        Picture picture = modelMapper.map(pictureImportDTO, Picture.class);
                        pictureRepository.saveAndFlush(picture);
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_PICTURE, picture.getSize()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "Picture"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }

    @Override
    public String exportPictures() {

        StringBuilder sb = new StringBuilder();

        List<Picture> pictures =
                pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000.00)
                        .orElseThrow(NoSuchElementException::new);

        pictures.forEach(picture -> sb.append(String.format(PRINT_OUTPUT,
                picture.getSize(),
                picture.getPath())));

        return sb.toString().trim();
    }

}
