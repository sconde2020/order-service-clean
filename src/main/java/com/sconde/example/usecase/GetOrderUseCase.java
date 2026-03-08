package com.sconde.example.usecase;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.repository.OrderRepository;

public class GetOrderUseCase {

    private final OrderRepository repository;

    public GetOrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
