package com.sconde.example.domain.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;

    public BigDecimal getPrice(){
        return price;
    }
}
