package com.sconde.example.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"LombokGetterMayBeUsed", "LombokSetterMayBeUsed"})
public class Order {

    private Long id;
    private String customerId;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.CREATED;

    public Order() {
    }

    public Order(String customerId, List<OrderItem> items) {
        this.customerId = customerId;
        this.items.addAll(items);
    }

    public Order(Long id, String customerId, OrderStatus status, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.items.addAll(items);
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

     public String getCustomerId() {
        return customerId;
    }

     public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
