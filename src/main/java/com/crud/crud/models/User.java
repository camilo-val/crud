package com.crud.crud.models;

import java.time.LocalDateTime;

import com.crud.crud.services.utils.CustomLocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;
    private String password;
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime modificationDate;

    public User() {
    }

    public User(String password, LocalDateTime creationDate, Long id, LocalDateTime modificationDate, String user) {
        this.password = password;
        this.creationDate = creationDate;
        this.id = id;
        this.modificationDate = modificationDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

}
