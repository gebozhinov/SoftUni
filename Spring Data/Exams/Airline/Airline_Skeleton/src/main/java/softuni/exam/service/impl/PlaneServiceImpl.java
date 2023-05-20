package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.plane.PlaneImportWrapper;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static softuni.exam.constant.Message.INVALID_DATA;
import static softuni.exam.constant.Message.SUCCESSFULLY_IMPORTED_PLANE;
import static softuni.exam.constant.Paths.IMPORT_PLANES_PATH;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PlaneServiceImpl(PlaneRepository planeRepository,
                            ModelMapper modelMapper,
                            ValidationUtil validationUtil) {
        this.planeRepository = planeRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(IMPORT_PLANES_PATH);
    }

    @Override
    public String importPlanes() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        File file = IMPORT_PLANES_PATH.toFile();
        JAXBContext context = JAXBContext.newInstance(PlaneImportWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PlaneImportWrapper planeImportWrapper = (PlaneImportWrapper) unmarshaller.unmarshal(file);

        planeImportWrapper.getPlanes()
                .forEach(planeImportDTO -> {
                    boolean isValid = validationUtil.isValid(planeImportDTO);

                    if (isValid) {
                        Plane plane = modelMapper.map(planeImportDTO, Plane.class);
                        planeRepository.saveAndFlush(plane);
                        sb.append(String.format(SUCCESSFULLY_IMPORTED_PLANE, plane.getRegisteredNumber()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append(String.format(INVALID_DATA, "Plane"))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }
}
