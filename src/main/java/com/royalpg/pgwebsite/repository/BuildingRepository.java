package com.royalpg.pgwebsite.repository;

import com.royalpg.pgwebsite.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    boolean existsByName(String name);
}
