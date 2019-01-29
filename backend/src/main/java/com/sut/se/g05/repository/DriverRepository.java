package com.sut.se.g05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g05.entity.Driver;

@RepositoryRestResource
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByDriverId(Long driverId);
}