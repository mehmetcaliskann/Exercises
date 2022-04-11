package com.mehmetcaliskan.carrentalapp.service;

import com.mehmetcaliskan.carrentalapp.entity.RentalCar;
import com.mehmetcaliskan.carrentalapp.repository.RentalCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalCarService {
    private final RentalCarRepository rentalCarRepository;

    public RentalCar addRentalCar(RentalCar rentalCar) {
        return rentalCarRepository.save(rentalCar);
    }

    public RentalCar getRentalCar(Long id) {
        return rentalCarRepository.findById(id).orElse(null);
    }

    public RentalCar updateRentalCar(Long id, RentalCar rentalCar) {
        RentalCar rentalCar1 = rentalCarRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental Car not found"));
        rentalCar1.setBrand(rentalCar.getBrand());
        rentalCar1.setModel(rentalCar.getModel());
        rentalCar1.setCarType(rentalCar.getCarType());
        rentalCar1.setPrice(rentalCar.getPrice());
        rentalCar1.setCompany(rentalCar.getCompany());
        return rentalCarRepository.save(rentalCar1);
    }

    public void deleteRentalCar(Long id) {
        rentalCarRepository.deleteById(id);
    }
}
