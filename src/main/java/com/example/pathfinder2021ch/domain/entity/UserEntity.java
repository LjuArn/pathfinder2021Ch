package com.example.pathfinder2021ch.domain.entity;

import com.example.pathfinder2021ch.domain.entity.enums.LevelUserEnum;
import com.example.pathfinder2021ch.domain.entity.enums.RoleNameEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column
    private String email;
    @Column
    private Integer age;
    @Column
    @Enumerated(EnumType.STRING)
    private LevelUserEnum level;

    @ManyToMany
    private Set<RoleEntity> roles;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public LevelUserEnum getLevel() {
        return level;
    }

    public UserEntity setLevel(LevelUserEnum level) {
        this.level = level;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}


//The User Entity should hold the following properties
//•	username - Accepts String values
//o	Accepts values, which should be at least 2 characters

//•	password - Accepts String values
//o	Accepts values, which should be at least 2 characters

//•	email - Accepts String values
//o	Accepts values, which contain the '@' symbol

//•	role - Accepts Role Entity values
//o	Each registered user should have a "User" role

//•	level - Accepts a level of the user (BEGINNER, INTERMEDIATE, ADVANCED)