package com.royalpg.pgwebsite.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactNo;
    private String guardianName;
    private String guardianContactNo;
    private LocalDate admissionDate;
    private String workPlace;
    private String aadhaarNo;
    private String building;
    private String roomNo;
    private String roomType;
}
