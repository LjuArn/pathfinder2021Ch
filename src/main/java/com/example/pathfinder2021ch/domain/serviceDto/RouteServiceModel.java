package com.example.pathfinder2021ch.domain.serviceDto;

import com.example.pathfinder2021ch.domain.entity.CategoriesEntity;
import com.example.pathfinder2021ch.domain.entity.PicturesEntity;
import com.example.pathfinder2021ch.domain.entity.UserEntity;
import com.example.pathfinder2021ch.domain.entity.enums.LevelRouteEnum;
import jakarta.persistence.*;

import java.util.Set;

public class RouteServiceModel {

    private Long id;
    private String gpxCoordinates;
    private String description;
    private LevelRouteEnum level;
    private String name;
    private String videoUrl;
    private UserEntity author;
    private Set<CategoriesEntity> categories;
    private Set<PicturesEntity> pictures;

    public RouteServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LevelRouteEnum getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(LevelRouteEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public Set<CategoriesEntity> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<CategoriesEntity> categories) {
        this.categories = categories;
        return this;
    }

    public Set<PicturesEntity> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<PicturesEntity> pictures) {
        this.pictures = pictures;
        return this;
    }
}
