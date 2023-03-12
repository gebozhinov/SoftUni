package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column
    private String logo;
    @Column(length = 3)
    private String initials;

    @OneToOne
    @JoinColumn(name = "primary_kit_color")
    private Color primaryKitColor;

    @OneToOne
    @JoinColumn(name = "secondary_kit_color")
    private Color secondaryKitColor;
    @ManyToOne
    private Town town;
    @Column
    private BigDecimal budget;
    @OneToMany(mappedBy = "team")
    private Set<Player> players;

    public Team() {}


}
