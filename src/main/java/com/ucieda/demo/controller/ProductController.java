package com.ucieda.demo.controller;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Product;
import com.ucieda.demo.service.BrandService;
import com.ucieda.demo.service.DiscountService;
import com.ucieda.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final BrandService brandService;
    private final DiscountService discountService;

    @GetMapping(value = "/product")
    public List<Product> products() {
        return productService.productList();
    }

    @GetMapping(value = "/brand")
    public List<Brand> brands() {
        return brandService.productList();
    }

    @GetMapping(value = "/findDiscounts")
    public List<DiscountResponse> findDiscounts(@RequestParam Long productId,
                                        @RequestParam Long brandId,
                                        @RequestParam("applyDate")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                        LocalDateTime applyDate) {
        return discountService.discountList(brandId, productId, applyDate);
    }


/*
-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
http://localhost:8080/findDiscounts?applyDate=2020-06-14T10%3A00%3A00&productId=1&brandId=1

-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
http://localhost:8080/findDiscounts?applyDate=2020-06-14T16%3A00%3A00&productId=1&brandId=1

-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
http://localhost:8080/findDiscounts?applyDate=2020-06-14T21%3A00%3A00&productId=1&brandId=1

-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
http://localhost:8080/findDiscounts?applyDate=2020-06-15T10%3A00%3A00&productId=1&brandId=1

-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
http://localhost:8080/findDiscounts?applyDate=2020-06-16T21%3A00%3A00&productId=1&brandId=1
*
* */
}
