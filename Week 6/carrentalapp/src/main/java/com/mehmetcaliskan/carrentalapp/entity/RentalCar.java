package com.mehmetcaliskan.carrentalapp.entity;

import com.mehmetcaliskan.carrentalapp.enums.CarTypeEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CarTypeEnum carType;

    @NotBlank
    private String model;

    @NotNull
    private Long price;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "rentalCar", cascade = CascadeType.ALL)
    private List<PriceRange> priceRanges;
}
