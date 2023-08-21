package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodName;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "mood_name", unique = true, nullable = false)
    private MoodName moodName;

    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(targetEntity = Post.class, mappedBy = "mood")
    private Set<Post> posts;
    public Long getId() {
        return id;
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public Mood setMoodName(MoodName moodName) {
        this.moodName = moodName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Mood setDescription(String description) {
        this.description = description;
        return this;
    }
}
