package com.sconde.example.infrastructure.payment;

import com.sconde.example.usecase.port.PaymentService;

import java.math.BigDecimal;

public class StripePaymentAdapter implements PaymentService {

    private final StripePaymentClient client;

    public StripePaymentAdapter(StripePaymentClient client){
        this.client = client;
    }

    @Override
    public void pay(BigDecimal amount) {

        client.charge(amount);
    }
}
