package com.example.usersystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    @Column
    private String title;
    @Column
    private String caption;
    @Column
    private String path;
    @ManyToMany(mappedBy = "pictures", cascade = CascadeType.ALL)
    private List<Album> albums = new ArrayList<>();
}
