package com.mehmetcaliskan.carrentalapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private PriceRange priceRange;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    public Reservation(Customer customer, RentalCar rentalCar, PriceRange priceRange, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.rentalCar = rentalCar;
        this.priceRange = priceRange;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
