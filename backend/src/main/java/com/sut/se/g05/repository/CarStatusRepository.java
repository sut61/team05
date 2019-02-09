package com.sut.se.g05.repository;
import com.sut.se.g05.entity.CarStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin (origins = "http: //localhost:4200")
public interface CarStatusRepository extends JpaRepository<CarStatus,Long>{
    CarStatus findByStatusType(String statusType);

}