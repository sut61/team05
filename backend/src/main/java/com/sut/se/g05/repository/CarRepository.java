package com.sut.se.g05.repository;

import com.sut.se.g05.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CarRepository extends JpaRepository<Car, Long> {
    Car findByCarId(Long carbrand);
    // Car findBylicenseplate(String licenseplate);

}