package com.ucieda.demo.repository;

import com.ucieda.demo.domain.Discount;
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
class DiscountRepositoryTest {

    @Autowired
    private DiscountRepository discountRepository;
    
    @Test
    void findDiscount() {
    }

    // JUnit test for saveDiscount
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveDiscountTest() {

        Discount discount = Discount.builder()
                .discountValue(1.0)
                .priority(0)
                .build();

        discountRepository.save(discount);

        Assertions.assertThat(discount.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getDiscountTest() {

        Discount discount = discountRepository.findById(1L).get();

        Assertions.assertThat(discount.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfDiscountsTest() {

        List<Discount> discounts = discountRepository.findAll();

        Assertions.assertThat(discounts.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateDiscountTest() {

        Discount discount = discountRepository.findById(1L).get();

        discount.setPriority(0);

        Discount discountUpdated = discountRepository.save(discount);

        Assertions.assertThat(discountUpdated.getPriority()).isEqualTo(0);

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteDiscountTest() {

        Discount discount = discountRepository.findById(1L).get();

        discountRepository.delete(discount);

        Discount discount1 = null;

        Optional<Discount> optionalDiscount = discountRepository.findById(1L);

        if (optionalDiscount.isPresent()) {
            discount1 = optionalDiscount.get();
        }

        Assertions.assertThat(discount1).isNull();
    }
}