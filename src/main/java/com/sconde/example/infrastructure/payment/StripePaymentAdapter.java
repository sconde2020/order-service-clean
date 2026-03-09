package com.sconde.example.infrastructure.payment;

import com.sconde.example.domain.port.PaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
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
