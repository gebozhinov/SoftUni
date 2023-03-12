package entitites;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<BillingDetail> billingDetails;

    public User() {
    }
}
