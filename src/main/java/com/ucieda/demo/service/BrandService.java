package com.ucieda.demo.service;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> productList(){
        return brandRepository.findAll();
    }
}
