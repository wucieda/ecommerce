package com.ucieda.demo.repository;

import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    List<Discount> findByProduct(Product product);

    @Query("select a from Discount a " +
            "where a.product = :product " +
            "and a.startDate <= :applicationDateTime " +
            "and a.endDate >= :applicationDateTime " +
            "order by a.priority asc")
    List<Discount> findDiscount(
            @Param("product") Product product,
            @Param("applicationDateTime") LocalDateTime applicationDateTime);
}