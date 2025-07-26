package com.royalpg.pgwebsite.controller;

import com.royalpg.pgwebsite.entity.RentEntity;
import com.royalpg.pgwebsite.model.Rent;
import com.royalpg.pgwebsite.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @PostMapping
    public ResponseEntity<?> addRent(@RequestBody Rent rent) {
        try {
            RentEntity savedRent = rentService.saveRent(rent);
            return ResponseEntity.ok(savedRent);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<RentEntity>> getAllRentData() {
        List<RentEntity> rents = rentService.getAllRentData();
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @GetMapping("/{roomType}")
    public ResponseEntity<RentEntity> getRentByRoomType(@PathVariable String roomType) {
        RentEntity rent = rentService.getRentEntityByRoomType(roomType);
        return new ResponseEntity<>(rent, HttpStatus.OK);
    }

    @PutMapping("/{roomType}")
    public ResponseEntity<RentEntity> updateRentByRoomType(
            @PathVariable String roomType,
            @RequestBody RentEntity rent) {
        RentEntity updated = rentService.updateRentByRoomType(roomType, rent);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
