package bg.softuni.exercisespringdataautomappingobjects.model.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

import static bg.softuni.exercisespringdataautomappingobjects.Constant.Validation.*;

@Getter
public class GameDTO {

    private String title;
    private BigDecimal price;
    private double size;
    private String trailer;
    private String imgUrl;
    private String description;
    private LocalDate releaseDate;

    public GameDTO(String title,
                   BigDecimal price,
                   double size,
                   String trailer,
                   String imgUrl,
                   String description,
                   LocalDate releaseDate) {
        setTitle(title);
        setPrice(price);
        setSize(size);
        setTrailer(trailer);
        setImgUrl(imgUrl);
        setDescription(description);
        setReleaseDate(releaseDate);
    }

    public void setTitle(String title) {
        if (!Character.isUpperCase(title.charAt(0)) &&
                (title.length() < 3 || title.length() > 100)) {
            throw new IllegalArgumentException(INVALID_TITLE);
        }
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setSize(double size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
        this.size = size;
    }

    public void setTrailer(String trailer) {
        if (trailer.length() != 11) {
            throw new IllegalArgumentException(INVALID_TRAILER);
        }
        this.trailer = trailer;
    }

    public void setImgUrl(String imgUrl) {
        if (!imgUrl.startsWith("http://") && !imgUrl.startsWith("https://")) {
            throw new IllegalArgumentException(INVALID_IMAGE_URL);
        }
        this.imgUrl = imgUrl;
    }

    public void setDescription(String description) {
        if (description.length() < 20) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION_LENGTH);
        }
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
