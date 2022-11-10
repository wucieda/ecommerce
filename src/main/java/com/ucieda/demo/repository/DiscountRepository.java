package com.ucieda.demo.repository;

import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    List<Discount> findByProduct(Product product);
}