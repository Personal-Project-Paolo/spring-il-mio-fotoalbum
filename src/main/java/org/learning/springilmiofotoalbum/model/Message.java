package org.learning.springilmiofotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String email;

    @NotBlank(message = "Message must not be blank")
    @Size(max = 2500, message = "Length must be less than 2500")
    @Column(length = 2500)
    private String message;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    //Get/Set --- Relazione
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
