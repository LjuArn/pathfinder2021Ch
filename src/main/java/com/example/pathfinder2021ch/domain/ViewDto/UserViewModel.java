package com.example.pathfinder2021ch.domain.ViewDto;

import com.example.pathfinder2021ch.domain.entity.RoleEntity;
import com.example.pathfinder2021ch.domain.entity.enums.LevelUserEnum;

import java.util.Set;

public class UserViewModel {
    private Long id;
    private String fullName;
    private String username;
    private Integer age;
    private LevelUserEnum level;

    public UserViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public LevelUserEnum getLevel() {
        return level;
    }

    public UserViewModel setLevel(LevelUserEnum level) {
        this.level = level;
        return this;
    }
}
