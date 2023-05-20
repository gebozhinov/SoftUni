package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "tickets")
@Entity
public class Ticket extends BaseEntity {

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;
    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime takeOff;

    @OneToOne
    private Town fromTown;
    @OneToOne
    private Town toTown;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Plane plane;

}
