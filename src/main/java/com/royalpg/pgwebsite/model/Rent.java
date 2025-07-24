package com.royalpg.pgwebsite.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rent {
    private String roomType;
    private double lowRent;
    private double highRent;
}
