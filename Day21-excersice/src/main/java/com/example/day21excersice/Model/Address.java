package com.example.day21excersice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    private Integer id;
    @NotEmpty(message = "area shouldn't be empty")
    private String area;
    @NotEmpty(message = "street shouldn't be empty")
    private String street;
    @NotNull(message = "building number shouldn't be empty")
    private Integer buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher1;
}
