package com.ucieda.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double basePrice;
    private String currency;

    @OneToOne
    @JoinColumn(name = "productId")
    @JsonBackReference
    private Product product; //FK

}
