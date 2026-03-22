package com.sconde.example.application;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class GetOrderUseCase {

    OrderRepository repository;

    public Order execute(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
