package bg.softuni.exercisejson.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @Size(min = 3)
    private String lastName;
    @Column
    private int age;

    @OneToMany(targetEntity = Product.class, mappedBy = "sellerId", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Set<Product> productsSold;
    @OneToMany(targetEntity = Product.class, mappedBy = "buyerId", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Set<Product> productsBought;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_friends", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, getId());
    }
}
