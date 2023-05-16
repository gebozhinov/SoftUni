package softuni.exam.instagraphlite.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "pictures")
@Entity
public class Picture extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String path;
    @Column(nullable = false)
    private Double size;

    @OneToMany(targetEntity = User.class, mappedBy = "profilePicture")
    private List<User> users;

    @OneToMany(targetEntity = Post.class, mappedBy = "picture")
    private List<Post> posts;
}
