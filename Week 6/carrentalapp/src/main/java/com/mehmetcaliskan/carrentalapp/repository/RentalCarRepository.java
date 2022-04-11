package com.mehmetcaliskan.carrentalapp.repository;

import com.mehmetcaliskan.carrentalapp.entity.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {
}
