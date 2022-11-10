package com.ucieda.demo.repository;

import com.ucieda.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT u FROM Product u WHERE u.id = :id and u.brand.id = :brandId")
    Product findProduct(@Param("id") Long id,
                        @Param("brandId") Long brandId);

}