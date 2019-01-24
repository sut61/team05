package com.sut.se.g05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g05.entity.Repairinfo;

@RepositoryRestResource
public interface RepairinfoRepository extends JpaRepository<Repairinfo, Long> {
    Repairinfo findById(long id);
}
