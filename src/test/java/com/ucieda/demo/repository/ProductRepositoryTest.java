package com.ucieda.demo.repository;

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
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findProduct() {
    }

  

    // JUnit test for saveProduct
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProductTest() {

        Product product = Product.builder()
                .name("Camisa")
                .description("color rojo")
                .build();

        productRepository.save(product);

        Assertions.assertThat(product.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getProductTest() {

        Product product = productRepository.findById(1L).get();

        Assertions.assertThat(product.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfProductsTest() {

        List<Product> products = productRepository.findAll();

        Assertions.assertThat(products.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProductTest() {

        Product product = productRepository.findById(1L).get();

        product.setName("Bershka");

        Product productUpdated = productRepository.save(product);

        Assertions.assertThat(productUpdated.getName()).isEqualTo("Bershka");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteProductTest() {

        Product product = productRepository.findById(1L).get();

        productRepository.delete(product);

        Product product1 = null;

        Optional<Product> optionalProduct = productRepository.findByName("Bershka");

        if (optionalProduct.isPresent()) {
            product1 = optionalProduct.get();
        }

        Assertions.assertThat(product1).isNull();
    }
}