package com.royalpg.pgwebsite.controller;

import com.royalpg.pgwebsite.entity.BuildingEntity;
import com.royalpg.pgwebsite.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity<BuildingEntity> addBuilding(@RequestBody BuildingEntity building) {
        BuildingEntity savedBuilding = buildingService.addBuilding(building);
        return ResponseEntity.ok(savedBuilding);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBuilding(@PathVariable Long id) {
        try {
            buildingService.deleteBuildingById(id);
            return ResponseEntity.ok("Building with id " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public List<BuildingEntity> getAllBuildings() {
        return buildingService.getAllBuildings();
    }
}
