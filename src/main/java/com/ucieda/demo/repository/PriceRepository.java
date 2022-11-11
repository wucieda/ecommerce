package com.ucieda.demo.repository;

import com.ucieda.demo.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}