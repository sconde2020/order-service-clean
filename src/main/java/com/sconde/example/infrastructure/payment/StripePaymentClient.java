package com.sconde.example.infrastructure.payment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StripePaymentClient {

    public void charge(BigDecimal amount){

        System.out.println("Charging with Stripe : " + amount);
    }
}
