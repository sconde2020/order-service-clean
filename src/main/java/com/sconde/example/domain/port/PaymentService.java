package com.sconde.example.domain.port;

import java.math.BigDecimal;

public interface PaymentService {

    void pay(BigDecimal amount);
}
