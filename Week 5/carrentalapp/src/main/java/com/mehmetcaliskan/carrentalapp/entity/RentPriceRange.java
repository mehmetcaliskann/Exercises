package com.mehmetcaliskan.carrentalapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class RentPriceRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_car_id", referencedColumnName = "id")
    private RentalCar rentalCar;

    @NotNull
    private Long price;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
}
