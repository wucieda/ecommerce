package com.ucieda.demo;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Price;
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

        Discount discount1 = new Discount();
        discount1.setStartDate(new Date());
        discount1.setEndDate(new Date());
        discount1.setDiscountValue(1.0);
        discount1.setDiscountPriority(0);

        Discount discount2 = new Discount();
        discount2.setStartDate(new Date());
        discount2.setEndDate(new Date());
        discount2.setDiscountValue(1.0);
        discount2.setDiscountPriority(1);


        Price price1 = new Price();
        price1.setBasePrice(10.00);
        price1.setInActive(true);

        Price price2 = new Price();
        price2.setBasePrice(15.00);
        price2.setInActive(false);

        //agregar precios a producto
        product1.addPrice(price1);

        product2.addPrice(price2);


        //agregar descuento a producto
        product1.addDiscount(discount1);
        product1.addDiscount(discount2);


        //agregar productos a marca
        brand1.addProduct(product1);
        brand1.addProduct(product2);

        //guardar cliente, productos en la db
        productRepository.save(product1);
        productRepository.save(product2);
        brandRepository.save(brand1);
    }
}
