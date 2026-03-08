package com.sconde.example.usecase;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.repository.OrderRepository;

public class CreateOrderUseCase {

    private final OrderRepository repository;

    public CreateOrderUseCase(OrderRepository repository){
        this.repository = repository;
    }

    public Long execute(){

        Order order = new Order();

        repository.save(order);

        return order.getId();
    }
}
