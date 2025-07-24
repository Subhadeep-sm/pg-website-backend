package com.royalpg.pgwebsite.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomType; // e.g., Single Sharing, Double Sharing

    @Column(nullable = false)
    private double lowRent;

    @Column(nullable = false)
    private double highRent;
}