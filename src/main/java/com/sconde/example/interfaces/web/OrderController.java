package com.sconde.example.interfaces.web;

import com.sconde.example.interfaces.web.dto.CreateOrderRequest;
import com.sconde.example.usecase.CreateOrderUseCase;
import com.sconde.example.usecase.PayOrderUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final PayOrderUseCase payOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, PayOrderUseCase payOrderUseCase){
        this.createOrderUseCase = createOrderUseCase;
        this.payOrderUseCase = payOrderUseCase;
    }

    @PostMapping
    public Long create(CreateOrderRequest orderRequest) {
        return createOrderUseCase.execute();
    }

    @PostMapping("/{id}/pay")
    public void pay(@PathVariable Long id){

        payOrderUseCase.execute(id);
    }
}