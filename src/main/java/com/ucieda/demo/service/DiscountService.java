package com.ucieda.demo.service;

import com.ucieda.demo.domain.Brand;
import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.repository.BrandRepository;
import com.ucieda.demo.repository.DiscountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;

    public List<Discount> discountList(){
        return discountRepository.findAll();
    }
}
