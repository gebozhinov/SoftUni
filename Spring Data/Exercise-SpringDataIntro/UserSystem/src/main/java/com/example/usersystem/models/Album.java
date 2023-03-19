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
@Table(name = "albums")
public class Album extends BaseEntity {

    @Column
    private String name;
    @Column(name = "background_color")
    private String backgroundColor;
    @Column(name = "is_public")
    private boolean isPublic;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "albums_pictures",
    joinColumns = @JoinColumn(name = "album_id"),
    inverseJoinColumns = @JoinColumn(name = "picture_id"))
    private List<Picture> pictures = new ArrayList<>();
}
