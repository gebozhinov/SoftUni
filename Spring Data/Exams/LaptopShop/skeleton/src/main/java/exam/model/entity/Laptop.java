package exam.model.entity;

import exam.model.entity.enums.WarrantyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "laptops")
@Entity
public class Laptop extends BaseEntity {

    @Column(name = "mac_address", nullable = false, unique = true)
    private String macAddress;

    @Column(name = "cpu_speed", nullable = false)
    private Double cpuSpeed;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private Integer storage;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated
    @Column(name = "warranty_type", nullable = false)
    private WarrantyType warrantyType;

    @ManyToOne
    private Shop shop;
}
