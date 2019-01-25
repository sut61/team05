package com.sut.se.g05.repository;

import com.sut.se.g05.entity.Linked;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LinkedRepository extends JpaRepository<Linked,Long>{
    
}
