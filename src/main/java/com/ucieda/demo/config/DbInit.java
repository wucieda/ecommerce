package com.ucieda.demo.config;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Price;
import com.ucieda.demo.domain.Product;
import com.ucieda.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class DbInit {

    @Autowired
    private BrandRepository brandRepository;

    @PostConstruct
    private void postConstruct() {


        //crear descuentos
        Discount discount1 = new Discount();
        String start1 = "2020-06-14T00:00:00";
        String end1 = "2020-12-31T23:59:59";
        discount1.setStartDate(LocalDateTime.parse(start1));
        discount1.setEndDate(LocalDateTime.parse(end1));
        discount1.setDiscountValue(0.1125);
        discount1.setPriority(0);

        Discount discount2 = new Discount();
        String start2 = "2020-06-14T15:00:00";
        String end2 = "2020-06-14T18:30:00";
        discount2.setStartDate(LocalDateTime.parse(start2));
        discount2.setEndDate(LocalDateTime.parse(end2));
        discount2.setDiscountValue(0.36375);
        discount2.setPriority(1);

        Discount discount3 = new Discount();
        String start3 = "2020-06-15T00:00:00";
        String end3 = "2020-06-15T11:00:00";
        discount3.setStartDate(LocalDateTime.parse(start3));
        discount3.setEndDate(LocalDateTime.parse(end3));
        discount3.setDiscountValue(0.24375);
        discount3.setPriority(1);

        Discount discount4 = new Discount();
        String start4 = "2020-06-15T16:00:00";
        String end4 = "2020-12-31T23:59:59";
        discount4.setStartDate(LocalDateTime.parse(start4));
        discount4.setEndDate(LocalDateTime.parse(end4));
        discount4.setDiscountValue(0.02625);
        discount4.setPriority(1);

        Discount discount5 = new Discount();
        String start5 = "2020-06-14T00:00:00";
        String end5 = "2020-12-31T23:59:59";
        discount5.setStartDate(LocalDateTime.parse(start5));
        discount5.setEndDate(LocalDateTime.parse(end5));
        discount5.setDiscountValue(1.0);
        discount5.setPriority(2);

        Discount discount6 = new Discount();
        String start6 = "2020-06-14T00:00:00";
        String end6 = "2020-12-31T23:59:59";
        discount6.setStartDate(LocalDateTime.parse(start6));
        discount6.setEndDate(LocalDateTime.parse(end6));
        discount6.setDiscountValue(1.0);
        discount6.setPriority(2);

        //crear producto 1
        Product product1 = new Product();
        //product1.setId(35455L);
        product1.setName("camisa");
        product1.setDescription("camisa manga larga");

        //crear producto 2
        Product product2 = new Product();
        product2.setName("pantalon");
        product2.setDescription("pantalon negro");

        //crear producto 3
        Product product3 = new Product();
        product3.setName("zapato");
        product3.setDescription("zapato");

        //crear producto 4
        Product product4 = new Product();
        product4.setName("cinturon");
        product4.setDescription("cinturon");


        Price price1 = new Price();
        price1.setBasePrice(40.00);
        price1.setCurrency("EUR");

        Price price2 = new Price();
        price2.setBasePrice(40.00);
        price2.setCurrency("EUR");

        //agregar precios a producto
        product1.addPrice(price1);
        product2.addPrice(price2);


        //agregar descuento a producto
        product1.addDiscount(discount1);
        product1.addDiscount(discount2);
        product1.addDiscount(discount3);
        product1.addDiscount(discount4);
        product2.addDiscount(discount5);
        product2.addDiscount(discount6);


        //agregar productos a marca
        //crear  marca
        Brand brand1 = new Brand();
        brand1.setName("Zara");
        brand1.addProduct(product1);
        brand1.addProduct(product2);

        Brand brand2 = new Brand();
        brand2.setName("Bershka");
        brand2.addProduct(product3);
        brand2.addProduct(product4);

        //guardar cliente, productos en la db
        brandRepository.save(brand1);
        brandRepository.save(brand2);
    }
}