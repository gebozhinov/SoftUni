package bg.softuni.Pathfinder.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.UUID;

import static bg.softuni.Pathfinder.config.CloudinaryConfig.*;

@Service
public class ImageCloudService {

    private Cloudinary cloudinary;

    public ImageCloudService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET));
    }

    public void saveImage(MultipartFile multipartFile) {
        String imageId = UUID.randomUUID().toString();
        Map params = ObjectUtils.asMap(
            "public_id", imageId,
                "overwrite", true,
                "resource_type", "image"
        );

        File tempFile = new File(imageId);

        try {
            Files.write(tempFile.toPath(), multipartFile.getBytes());
            cloudinary.uploader().upload(tempFile, params);
            Files.delete(tempFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
