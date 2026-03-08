package com.sconde.example.domain.model;

import java.math.BigDecimal;

public class OrderItem {

    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal total(){

        return product.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }
}