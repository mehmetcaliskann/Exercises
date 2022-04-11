package com.mehmetcaliskan.carrentalapp.controller;

import com.mehmetcaliskan.carrentalapp.entity.RentalCar;
import com.mehmetcaliskan.carrentalapp.service.RentalCarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class RentalCarController {
    private final RentalCarService rentalCarService;

    @GetMapping("/{id}")
    public RentalCar getRentalCar(@PathVariable Long id) {
        return rentalCarService.getRentalCar(id);
    }

    @PutMapping("/{id}")
    public RentalCar updateRentalCar(@PathVariable Long id, @RequestBody @Valid RentalCar rentalCar) {
        return rentalCarService.updateRentalCar(id, rentalCar);
    }

    @PostMapping
    public RentalCar addRentalCar(@RequestBody @Valid RentalCar rentalCar) {
        return rentalCarService.addRentalCar(rentalCar);
    }

    @DeleteMapping("/{id}")
    public void deleteRentalCar(@PathVariable Long id) {
        rentalCarService.deleteRentalCar(id);
    }
}
