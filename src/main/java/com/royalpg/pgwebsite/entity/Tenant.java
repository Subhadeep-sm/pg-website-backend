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
    private Double rent;
    private LocalDate admissionDate;
    private String address;
    private String work;
    private String building;
}
