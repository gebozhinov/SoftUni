package entitites;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {
    @Id
    @Column(unique = true, nullable = false)
    private String number;
    @ManyToOne
    private User owner;

}
