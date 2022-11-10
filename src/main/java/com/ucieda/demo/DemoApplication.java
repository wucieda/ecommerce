package com.ucieda.demo;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Product;
import com.ucieda.demo.repository.BrandRepository;
import com.ucieda.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private  BrandRepository brandRepository;
    @Autowired
    private  ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {
        //crear  marca
        Brand brand1 = new Brand();
        brand1.setBrandName("Zara");

        //crear producto 1
        Product product1 = new Product();
        product1.setProductName("camisa");
        product1.setProductDescription("camisa manga larga");

        //crear producto 2
        Product product2 = new Product();
        product2.setProductName("pantalon");
        product2.setProductDescription("pantalon negro");

        Discount discount = new Discount();
        discount.setStartDate(new Date());
        discount.setEndDate(new Date());
        discount.setDiscountValue(1.0);


        //agregar productos a marca
        brand1.addProduct(product1);
        brand1.addProduct(product2);

        //guardar cliente, productos en la db
        productRepository.save(product1);
        productRepository.save(product2);
        brandRepository.save(brand1);
    }
}
