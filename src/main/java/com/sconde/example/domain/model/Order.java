package com.sconde.example.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.CREATED;

    public Order() {
    }

    public Order(Long id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }

    public void addItem(Product product, int quantity){
        items.add(new OrderItem(product, quantity));
    }

    public BigDecimal total(){

        return items.stream()
                .map(OrderItem::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void markPaid(){

        if(status == OrderStatus.PAID){
            throw new IllegalStateException("Order already paid");
        }

        status = OrderStatus.PAID;
    }

    public Long getId(){
        return id;
    }

    public List<OrderItem> getItems(){
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

}
