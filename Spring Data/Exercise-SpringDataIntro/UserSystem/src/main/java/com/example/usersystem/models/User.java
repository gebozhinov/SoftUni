package com.example.usersystem.models;

import com.example.usersystem.anotations.email.Email;
import com.example.usersystem.anotations.password.Password;
import com.example.usersystem.constants.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Length(min = 4, max = 30, message = Constants.INVALID_USERNAME_LENGTH)
    private String username;
    @Column(nullable = false)
    @Password(minLength = 6, maxLength = 50,
            hasLower = true,
            hasUpper = true,
            hasDigit = true,
            hasSpecialSymbol = true)
    private String password;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "registered_on")
    private LocalDate registeredOn;
    @Column(name = "last_time_login_in")
    private LocalDate lastTimeLoginIn;
    @Column
    @Min(value = 1)
    @Max(value = 120)
    private int age;
    @Column(name = "is_deleted")
    private boolean deleted;
    @ManyToOne
    @JoinColumn(name = "born_town_id")
    private Town bornTown;
    @ManyToOne
    @JoinColumn(name = "current_town_id")
    private Town currentTown;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany
    @JoinTable(name = "friends",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Album> albums = new HashSet<>();


    public String getFullName() {
        return String.format(this.firstName + " " + this.lastName);
    }


}
