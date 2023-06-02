package bg.softuni.supermarket.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Table(name = "towns")
@Entity
public class Town extends BaseEntity {

    @Column
    private String name;

    @OneToMany(targetEntity = Shop.class, mappedBy = "town")
    private Set<Shop> shops;

    public Town() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
