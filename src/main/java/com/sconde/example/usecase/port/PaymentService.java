package com.sconde.example.usecase.port;

import java.math.BigDecimal;

public interface PaymentService {

    void pay(BigDecimal amount);
}
