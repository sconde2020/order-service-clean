package com.sconde.example.application;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.repository.OrderRepository;
import com.sconde.example.domain.port.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class PayOrderUseCase {

    OrderRepository repository;
    PaymentService paymentService;

    public Order execute(Long orderId){

        Order order = repository.findById(orderId)
                .orElseThrow();

        paymentService.pay(order.total());

        order.markPaid();

        return repository.save(order);
    }
}
