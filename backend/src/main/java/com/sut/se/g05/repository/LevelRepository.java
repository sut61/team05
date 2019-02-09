package com.sut.se.g05.repository;

import com.sut.se.g05.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LevelRepository extends JpaRepository<Level, Long> {

    Level findByLevelId(Long levelId);
}
