package com.sconde.example.domain.repository;

import com.sconde.example.domain.model.Order;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(Long id);

    Order save(Order order);
}
