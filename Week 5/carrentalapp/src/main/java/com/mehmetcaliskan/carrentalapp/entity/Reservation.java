package com.mehmetcaliskan.carrentalapp.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_car_id", referencedColumnName = "id")
    private RentalCar rentalCar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_range_id", referencedColumnName = "id")
    private RentPriceRange rentPriceRange;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    public Reservation(Customer customer, RentalCar rentalCar, RentPriceRange rentPriceRange, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.rentalCar = rentalCar;
        this.rentPriceRange = rentPriceRange;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
