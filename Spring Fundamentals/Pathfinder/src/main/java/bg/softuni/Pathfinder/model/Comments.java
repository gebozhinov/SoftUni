package bg.softuni.Pathfinder.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "approved", nullable = false)
    private boolean isApproved;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(columnDefinition = "text",name = "text_content", nullable = false)
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;

    public Long getId() {
        return id;
    }

    public Comments setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public Comments setApproved(boolean approved) {
        isApproved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Comments setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comments setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comments setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comments setRoute(Route route) {
        this.route = route;
        return this;
    }
}
