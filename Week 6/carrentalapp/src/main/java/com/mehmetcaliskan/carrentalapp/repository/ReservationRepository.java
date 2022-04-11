package com.mehmetcaliskan.carrentalapp.repository;

import com.mehmetcaliskan.carrentalapp.entity.RentalCar;
import com.mehmetcaliskan.carrentalapp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByCustomerId(Long customerId);

    @Query(value = """
            SELECT *
            FROM reservation
            INNER JOIN rental_car
            ON reservation.rental_car_id = rental_car.id
            WHERE rentar_car.company_id = ?1
            """, nativeQuery = true)
    List<Reservation> findAllByCompanyId(Long companyId);

    List<Reservation> findAllByStartDateBetweenAndRentalCar(LocalDate startDate, LocalDate endDate, RentalCar rentalCar);
}
