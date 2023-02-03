package com.example.pathfinder2021ch.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "messages")
public class MessagesEntity extends BaseEntity{

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "text_content", nullable = false, columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private UserEntity recipient;


    public MessagesEntity() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public MessagesEntity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public MessagesEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public MessagesEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public UserEntity getRecipient() {
        return recipient;
    }

    public MessagesEntity setRecipient(UserEntity recipient) {
        this.recipient = recipient;
        return this;
    }
}

//•	date time - Accepts Date and Time values
//•	text content - Accepts very long String values
//•	author - Accepts User Entities as values
//•	recipient - Accepts User Entities as values