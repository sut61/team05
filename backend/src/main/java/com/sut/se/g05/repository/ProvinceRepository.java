package com.sut.se.g05.repository;

import com.sut.se.g05.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin (origins = "http: //localhost:4200")
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByprovince (String province);
    Province findByprovinceId (Long province);
}
