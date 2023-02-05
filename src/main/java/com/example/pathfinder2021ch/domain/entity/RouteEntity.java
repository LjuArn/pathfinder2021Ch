package com.example.pathfinder2021ch.domain.entity;

import com.example.pathfinder2021ch.domain.entity.enums.LevelRouteEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity{

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    @Enumerated(EnumType.STRING)
    private LevelRouteEnum level;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToMany
    private Set<CategoriesEntity> categories;

    public RouteEntity() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteEntity setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public LevelRouteEnum getLevel() {
        return level;
    }

    public RouteEntity setLevel(LevelRouteEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public Set<CategoriesEntity> getCategories() {
        return categories;
    }

    public RouteEntity setCategories(Set<CategoriesEntity> categories) {
        this.categories = categories;
        return this;
    }
}
//•	gpx coordinates - Accepts very long text values
//•	level - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values
//•	name - Accepts String values
//•	video url – Accepts the ids of youtube videos as values
//•	author - Accepts User Entities as values

