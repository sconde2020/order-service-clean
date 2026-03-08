package com.sconde.example.usecase;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.model.Product;
import com.sconde.example.domain.repository.OrderRepository;

public class AddItemUseCase {

    private final OrderRepository repository;

    public AddItemUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public void execute(Long orderId, Product product, int quantity){

        Order order = repository.findById(orderId)
                .orElseThrow();

        order.addItem(product, quantity);

        repository.save(order);
    }
}