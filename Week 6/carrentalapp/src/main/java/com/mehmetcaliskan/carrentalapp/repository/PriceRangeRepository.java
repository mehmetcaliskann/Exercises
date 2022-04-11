package com.mehmetcaliskan.carrentalapp.repository;

import com.mehmetcaliskan.carrentalapp.entity.PriceRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRangeRepository extends JpaRepository<PriceRange, Long> {
}
