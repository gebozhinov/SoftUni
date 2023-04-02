package bg.softuni.exercisespringdataautomappingobjects.model.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @ManyToMany
    @JoinTable(name = "users_games",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    private List<Game> games;
    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(targetEntity = Order.class, mappedBy = "user")
    private Set<Order> orders;

    public User() {
        this.games = new ArrayList<>();
        this.orders = new HashSet<>();

    }

}
