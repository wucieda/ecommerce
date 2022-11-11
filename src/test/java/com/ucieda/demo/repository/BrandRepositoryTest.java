package com.ucieda.demo.repository;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    // JUnit test for saveBrand
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveBrandTest() {

        Brand brand = Brand.builder()
                .name("Zara")
                .build();

        brandRepository.save(brand);

        Assertions.assertThat(brand.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getBrandTest() {

        Brand brand = brandRepository.findById(1L).get();

        Assertions.assertThat(brand.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfBrandsTest() {

        List<Brand> brands = brandRepository.findAll();

        Assertions.assertThat(brands.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateBrandTest() {

        Brand brand = brandRepository.findById(1L).get();

        brand.setName("Bershka");

        Brand brandUpdated = brandRepository.save(brand);

        Assertions.assertThat(brandUpdated.getName()).isEqualTo("Bershka");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteBrandTest() {

        Brand brand = brandRepository.findById(1L).get();

        brandRepository.delete(brand);

        Brand brand1 = null;

        Optional<Brand> optionalBrand = brandRepository.findByName("pantalon");

        if (optionalBrand.isPresent()) {
            brand1 = optionalBrand.get();
        }

        Assertions.assertThat(brand1).isNull();
    }

}