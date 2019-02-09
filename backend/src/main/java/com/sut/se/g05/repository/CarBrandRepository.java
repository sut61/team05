package com.sut.se.g05.repository;

import com.sut.se.g05.entity.CarBrand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin (origins = "http: //localhost:4200")
public interface CarBrandRepository extends JpaRepository<CarBrand,Long>{
    CarBrand findByBrand(String brand);

}
