package com.royalpg.pgwebsite.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "buildings")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true, nullable = false)
    private String name;

    // Constructors
    public BuildingEntity() {}

    public BuildingEntity(String name) {
        this.name = name;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
