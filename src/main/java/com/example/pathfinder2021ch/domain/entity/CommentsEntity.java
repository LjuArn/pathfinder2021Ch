package com.example.pathfinder2021ch.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentsEntity extends BaseEntity{


    @Column(nullable = false)
    private boolean approved;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(name = "text_content", columnDefinition = "LONGTEXT", nullable = false)
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;


    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    public CommentsEntity() {
    }

    public boolean isApproved() {
        return approved;
    }

    public CommentsEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentsEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentsEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public CommentsEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public CommentsEntity setRoute(RouteEntity route) {
        this.route = route;
        return this;
    }
}
//•	approved - Accepts boolean values
//•	created - Accepts Date and Time values    o	 The values should not be future dates
//•	text content - Accepts very long text values
//•	author - Accepts User Entities as values
//•	route - Accepts Route Entities as values