package com.royalpg.pgwebsite.repository;


import com.royalpg.pgwebsite.entity.RentEntity;
import com.royalpg.pgwebsite.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Long> {
    boolean existsByRoomType(String roomType);

    Optional<RentEntity> findByRoomType(String roomType);
}
