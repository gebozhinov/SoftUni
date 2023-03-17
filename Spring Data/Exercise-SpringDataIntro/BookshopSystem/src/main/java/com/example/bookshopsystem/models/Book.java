package com.example.bookshopsystem.models;

import com.example.bookshopsystem.models.enums.AgeRestriction;
import com.example.bookshopsystem.models.enums.EditionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book extends BaseEntity {
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
    private LocalDate releaseDate;
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

    public Book() {
        this.categories = new HashSet<>();
    }

    public Book(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.editionType = builder.editionType;
        this.price = builder.price;
        this.copies = builder.copies;
        this.releaseDate = builder.releaseDate;
        this.ageRestriction = builder.ageRestriction;
        this.author = builder.author;
        this.categories = builder.categories;
    }

    public static class Builder {
        private String title;
        private String description;
        private EditionType editionType;
        private BigDecimal price;
        private int copies;
        private LocalDate releaseDate;
        private AgeRestriction ageRestriction;
        private Author author;
        private Set<Category> categories;

        public Builder() {
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withEditionType(EditionType editionType) {
            this.editionType = editionType;
            return this;
        }

        public Builder withCopies(int copies) {
            this.copies = copies;
            return this;
        }

        public Builder withReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder withAgeRestriction(AgeRestriction ageRestriction) {
            this.ageRestriction = ageRestriction;
            return this;
        }

        public Builder withAuthor(Author author) {
            this.author = author;
            return this;
        }

        public Builder withCategory(Category category) {
            if (this.categories == null) {
                this.categories = new HashSet<>();
            }
            this.categories.add(category);
            return this;
        }

        public Book build() {
            return new Book(this);
        }


    }
}
