package com.example.bookshopsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Book> books;

    public Category(Builder builder) {
        this.name = builder.name;
    }

    public static class Builder {
        private String name;
        public Builder() {

        }
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Category build() {
            return new Category(this);
        }
    }

}
