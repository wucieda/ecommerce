package com.ucieda.demo.service;

import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Product;
import com.ucieda.demo.repository.DiscountRepository;
import com.ucieda.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;
    private final ProductRepository productRepository;

    public List<Discount> discountList(Long brandId, Long productId) {

        // encontrar un producto dado un id y dado id de la marca
       Product productSelected = productRepository.findProduct(productId, brandId);
        //del producto filtrar de la lista de descuentos los
        return discountRepository.findByProduct(productSelected);
        //esten en el rango de la fecha de entrada

    }
}
