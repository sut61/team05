package com.sut.se.g05.repositoty;
import com.sut.se.g05.entity.CarInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CarInformationRepository extends JpaRepository<CarInformation, Long> {
    CarInformation findBycarInformationId(String carInformation);

}