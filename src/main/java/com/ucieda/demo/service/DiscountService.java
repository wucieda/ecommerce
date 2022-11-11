package com.ucieda.demo.service;

import com.ucieda.demo.controller.DiscountResponse;
import com.ucieda.demo.domain.Discount;
import com.ucieda.demo.domain.Product;
import com.ucieda.demo.repository.DiscountRepository;
import com.ucieda.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;
    private final ProductRepository productRepository;

    public List<DiscountResponse> discountList(Long brandId, Long productId, LocalDateTime applyDate) {
        // encontrar un producto dado un id y dado id de la marca
        Product productSelected = productRepository.findProduct(productId, brandId);
        //del producto filtrar de la lista de descuentos los esten en el rango de la fecha de entrada
        List<Discount> discountList = discountRepository.findDiscount(productSelected, applyDate);

        List<DiscountResponse> discountResponses = new ArrayList<>();
        discountList.forEach(discount -> {
            DiscountResponse discountResponse = new DiscountResponse();
            discountResponse.setBrandId(brandId);
            discountResponse.setStartDate(discount.getStartDate());
            discountResponse.setEndDate(discount.getEndDate());
            discountResponse.setId(discount.getId());
            discountResponse.setProductId(productId);
            discountResponse.setPriority(discount.getPriority());
            //calcular nuevo precio con descuento
            Double total = productSelected.getPrice().getBasePrice();
            discountResponse.setPrice(total * (1 - discount.getDiscountValue()));
            discountResponse.setCurrency(productSelected.getPrice().getCurrency());
            discountResponses.add(discountResponse);
        });

        return discountResponses;
    }
}
