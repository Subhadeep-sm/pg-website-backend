package com.royalpg.pgwebsite.service;

import com.royalpg.pgwebsite.entity.BuildingEntity;
import com.royalpg.pgwebsite.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public BuildingEntity addBuilding(BuildingEntity building) {
        // Optional: Check for duplicates
        if (buildingRepository.existsByName(building.getName())) {
            throw new RuntimeException("Building already exists with name: " + building.getName());
        }
        return buildingRepository.save(building);
    }

    public void deleteBuildingById(Long id) {
        if (!buildingRepository.existsById(id)) {
            throw new RuntimeException("Building with ID " + id + " does not exist");
        }
        buildingRepository.deleteById(id);
    }

    public List<BuildingEntity> getAllBuildings() {
        return buildingRepository.findAll();
    }
}
