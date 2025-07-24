package com.royalpg.pgwebsite.service;

import com.royalpg.pgwebsite.entity.RentEntity;
import com.royalpg.pgwebsite.model.Rent;
import com.royalpg.pgwebsite.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public RentEntity saveRent(Rent rent) {
        if (rentRepository.existsByRoomType(rent.getRoomType())) {
            throw new IllegalArgumentException("Room type already exists!");
        }

        RentEntity rentEntity = RentEntity.builder()
                .roomType(rent.getRoomType())
                .lowRent(rent.getLowRent())
                .highRent(rent.getHighRent())
                .build();

        return rentRepository.save(rentEntity);
    }

    public List<RentEntity> getAllRentData() {
        return rentRepository.findAll();
    }

    public RentEntity getRentEntityByRoomType(String roomType) {
        return rentRepository.findByRoomType(roomType)
                .orElseThrow(() -> new RuntimeException("Room type not found: " + roomType));
    }

    public RentEntity updateRentByRoomType(String roomType, RentEntity updatedRent) {
        RentEntity existingRent = rentRepository.findByRoomType(roomType)
                .orElseThrow(() -> new RuntimeException("Room type not found: " + roomType));

        existingRent.setLowRent(updatedRent.getLowRent());
        existingRent.setHighRent(updatedRent.getHighRent());

        return rentRepository.save(existingRent);
    }
}
