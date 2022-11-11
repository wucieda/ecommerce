package com.ucieda.demo.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DiscountResponse {

    private Long brandId;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Long id;

    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;


}
