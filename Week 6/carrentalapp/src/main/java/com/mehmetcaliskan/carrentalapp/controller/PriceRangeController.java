package com.mehmetcaliskan.carrentalapp.controller;

import com.mehmetcaliskan.carrentalapp.entity.PriceRange;
import com.mehmetcaliskan.carrentalapp.service.PriceRangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/price-range")
@AllArgsConstructor
public class PriceRangeController {
    private final PriceRangeService priceRangeService;

    @GetMapping("/{id}")
    public PriceRange getPriceRange(@PathVariable Long id) {
        return priceRangeService.getPriceRange(id);
    }

    @PutMapping("/{id}")
    public PriceRange updatePriceRange(@PathVariable Long id, @RequestBody @Valid PriceRange priceRange) {
        return priceRangeService.updatePriceRange(id, priceRange);
    }

    @DeleteMapping("/{id}")
    public void deletePriceRange(@PathVariable Long id) {
        priceRangeService.deletePriceRange(id);
    }

    @PostMapping
    public PriceRange addPriceRange(@RequestBody @Valid PriceRange priceRange) {
        return priceRangeService.addPriceRange(priceRange);
    }
}
