package com.example.pathfinder2021ch.domain.bidingDto;

import jakarta.persistence.Column;

public class UserRegisterBidingModel {


    private String username;
    private String fullName;
    private String email;
    private Integer age;
    private String password;
    private String confirmPassword;

    public UserRegisterBidingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBidingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBidingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBidingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterBidingModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBidingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBidingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
