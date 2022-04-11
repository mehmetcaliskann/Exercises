package com.mehmetcaliskan.carrentalapp.service;

import com.mehmetcaliskan.carrentalapp.entity.PriceRange;
import com.mehmetcaliskan.carrentalapp.repository.PriceRangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceRangeService {
    private final PriceRangeRepository priceRangeRepository;

    public PriceRange addPriceRange(PriceRange priceRange) {
        return priceRangeRepository.save(priceRange);
    }

    public PriceRange getPriceRange(Long id) {
        return priceRangeRepository.findById(id).orElse(null);
    }

    public PriceRange updatePriceRange(Long id, PriceRange priceRange) {
        PriceRange priceRange1 = priceRangeRepository.findById(id).orElseThrow(() -> new RuntimeException("Price Range not found"));
        priceRange1.setPrice(priceRange.getPrice());
        priceRange1.setEndDate(priceRange.getEndDate());
        priceRange1.setStartDate(priceRange.getStartDate());
        priceRange1.setRentalCar(priceRange.getRentalCar());
        return priceRangeRepository.save(priceRange1);
    }

    public void deletePriceRange(Long id) {
        priceRangeRepository.deleteById(id);
    }
}
