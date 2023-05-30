package com.example.day21excersice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer AddressId;
    private String area;
    private String street;
    private Integer buildingNumber;
}
