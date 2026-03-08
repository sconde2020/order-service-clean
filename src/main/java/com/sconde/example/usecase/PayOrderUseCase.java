package com.sconde.example.usecase;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.repository.OrderRepository;
import com.sconde.example.usecase.port.PaymentService;

public class PayOrderUseCase {

    private final OrderRepository repository;
    private final PaymentService paymentService;

    public PayOrderUseCase(OrderRepository repository,
                           PaymentService paymentService){

        this.repository = repository;
        this.paymentService = paymentService;
    }

    public void execute(Long orderId){

        Order order = repository.findById(orderId)
                .orElseThrow();

        paymentService.pay(order.total());

        order.markPaid();

        repository.save(order);
    }
}
