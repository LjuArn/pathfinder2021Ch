package com.example.pathfinder2021ch.domain.entity;

import com.example.pathfinder2021ch.domain.entity.enums.NameCategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private NameCategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoriesEntity() {
    }

    public NameCategoryEnum getName() {
        return name;
    }

    public CategoriesEntity setName(NameCategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoriesEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
//•	name - Accepts String values (PEDESTRIAN, BICYCLE, MOTORCYCLE, CAR)
//•	description - Accepts very long String values