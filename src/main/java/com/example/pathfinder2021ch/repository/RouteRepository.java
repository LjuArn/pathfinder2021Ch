package com.example.pathfinder2021ch.repository;

import com.example.pathfinder2021ch.domain.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

}
