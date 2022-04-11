package com.mehmetcaliskan.carrentalapp.entity;

import com.mehmetcaliskan.carrentalapp.enums.CityEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6, max = 64)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CityEnum city;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<RentalCar> rentalCars;
}
