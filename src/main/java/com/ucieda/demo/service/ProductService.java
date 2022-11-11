package com.ucieda.demo.service;

import com.ucieda.demo.domain.Product;
import com.ucieda.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> productList(){
        return productRepository.findAll();
    }
}
