package softuni.exam.instagraphlite.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
@Entity
public class Post extends BaseEntity {

    @Column(nullable = false)
    private String caption;

    @ManyToOne
    private User user;

    @ManyToOne
    private Picture picture;

}
