package com.sut.se.g05.repository;

import com.sut.se.g05.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findBypositionid (Long positionid);
}
