package com.example.bookshopsystem.models;

import com.example.bookshopsystem.models.enums.AgeRestriction;
import com.example.bookshopsystem.models.enums.EditionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity{
        @Column(length = 50, nullable = false)
        private String title;
        @Column(length = 1000)
        private String description;
        @Column(name = "edition_type", nullable = false)
        @Enumerated(EnumType.STRING)
        private EditionType editionType;
        @Column(nullable = false)
        private BigDecimal price;
        @Column(nullable = false)
        private int copies;
        @Column(name = "release_date")
        private Date relaseDate;
        @Column(name = "age_restriction", nullable = false)
        @Enumerated(EnumType.STRING)
        private AgeRestriction ageRestriction;
        @ManyToOne
        private Author author;

        @ManyToMany
        @JoinTable(name = "books_categories",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
        private Set<Category> categories;
}
