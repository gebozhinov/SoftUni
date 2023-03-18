package com.example.bookshopsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author() {
        this.books = new HashSet<>();
    }

    public Author(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder() {}
        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Author build() {
            return new Author(this);
        }
    }

}
