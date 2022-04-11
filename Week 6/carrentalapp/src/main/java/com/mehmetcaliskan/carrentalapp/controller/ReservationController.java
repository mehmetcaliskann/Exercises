package com.mehmetcaliskan.carrentalapp.controller;

import com.mehmetcaliskan.carrentalapp.entity.Reservation;
import com.mehmetcaliskan.carrentalapp.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/reservation")
@RestController
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody @Valid Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody @Valid Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping("/customer/{id}")
    public List<Reservation> getReservationsOfCustomer(@PathVariable Long id) {
        return reservationService.getReservationsOfCustomer(id);
    }

    @GetMapping("/company/{id}")
    public List<Reservation> getReservationsOfCompany(@PathVariable Long id) {
        return reservationService.getReservationsOfCompany(id);
    }
}
