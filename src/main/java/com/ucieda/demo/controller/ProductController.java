package com.ucieda.demo.controller;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Product;
import com.ucieda.demo.service.BrandService;
import com.ucieda.demo.service.DiscountService;
import com.ucieda.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Discount> findDiscounts(@RequestParam Long productId,
                                        @RequestParam Long brandId) {
        return discountService.discountList(brandId, productId);
    }
}
