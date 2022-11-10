package com.ucieda.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; //PK
    private String productName;
    private String productDescription;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "brandId")
    @JsonBackReference
    private Brand brand; //FK

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference
    private List<Discount> discounts;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Price price;

    public void addDiscount(Discount discount){
        if(discounts==null) discounts = new ArrayList<>();
        discounts.add(discount);
        discount.setProduct(this);
    }

    public void addPrice(Price price){
        if(this.price==null) this.price = price;
        price.setProduct(this);
    }


}
