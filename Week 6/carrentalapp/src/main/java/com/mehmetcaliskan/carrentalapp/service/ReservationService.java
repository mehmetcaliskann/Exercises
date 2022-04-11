package com.mehmetcaliskan.carrentalapp.service;

import com.mehmetcaliskan.carrentalapp.entity.RentalCar;
import com.mehmetcaliskan.carrentalapp.entity.Reservation;
import com.mehmetcaliskan.carrentalapp.repository.RentalCarRepository;
import com.mehmetcaliskan.carrentalapp.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RentalCarRepository rentalCarRepository;

    public Reservation addReservation(Reservation reservation) {
        RentalCar rentalCar = rentalCarRepository.findById(reservation.getRentalCar().getId()).orElseThrow(() -> new RuntimeException("Rental car not found"));
        List<Reservation> reservations = getReservationsByDates(reservation.getStartDate(), reservation.getEndDate(), rentalCar);
        if (reservations.size() > 0) {
            throw new RuntimeException("Rezervasyon yapılan tarihte ilgili aracın müsait olması ve başka kiralama ile çakışmaması gerekmektedir.");
        }
        return reservationRepository.save(reservation);
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation reservation1 = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation1.setStartDate(reservation.getStartDate());
        reservation1.setEndDate(reservation.getEndDate());
        reservation1.setCustomer(reservation.getCustomer());
        reservation1.setPriceRange(reservation.getPriceRange());
        reservation1.setPriceRange(reservation.getPriceRange());
        return reservationRepository.save(reservation1);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        LocalDate today = LocalDate.now();

        if (reservation.getStartDate().minusDays(1L).isAfter(today)) {
            throw new RuntimeException("Rezervasyonlar en erken 1 gün öncesinden iptal edilebilir.");
        }

        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsOfCustomer(Long customerId) {
        return reservationRepository.findAllByCustomerId(customerId);
    }

    public List<Reservation> getReservationsOfCompany(Long companyId) {
        return reservationRepository.findAllByCompanyId(companyId);
    }

    public List<Reservation> getReservationsByDates(LocalDate startDate, LocalDate endDate, RentalCar rentalCar) {
        return reservationRepository.findAllByStartDateBetweenAndRentalCar(startDate, endDate, rentalCar);
    }
}
