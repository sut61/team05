package com.sut.se.g05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.g05.entity.Damage;

@RepositoryRestResource
public interface DamageRepository extends JpaRepository<Damage, Long> {

    Damage findByDamageId(Long damageId);
}
