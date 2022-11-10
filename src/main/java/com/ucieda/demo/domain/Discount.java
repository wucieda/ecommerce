package com.ucieda.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long productId; //FK
    private Double discountValue;
    private String currency; //discount_unit
    private Date startDate;
    private Date endDate;
    private Integer discountPriority;

    private String couponCode;
    private Integer minimumOrderValue;
    private Integer maximumOrderValue;

    private Date createdDate;


}

//https://docs.tibco.com/pub/af/4.0.0/doc/html/GUID-A8B10C5C-7F70-4CBF-AE53-C2A084D1FD4D.html

