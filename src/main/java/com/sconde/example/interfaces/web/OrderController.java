package com.sconde.example.interfaces.web;

import com.sconde.example.domain.model.Order;
import com.sconde.example.interfaces.web.dto.AddItemRequest;
import com.sconde.example.interfaces.web.dto.CreateOrderRequest;
import com.sconde.example.interfaces.web.dto.OrderResponse;
import com.sconde.example.interfaces.web.mapper.OrderDtoMapper;
import com.sconde.example.usecase.AddItemUseCase;
import com.sconde.example.usecase.CreateOrderUseCase;
import com.sconde.example.usecase.GetOrderUseCase;
import com.sconde.example.usecase.PayOrderUseCase;
import com.sconde.example.usecase.command.AddItemCommand;
import com.sconde.example.usecase.command.CreateOrderCommand;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class OrderController {

    CreateOrderUseCase createOrderUseCase;
    PayOrderUseCase payOrderUseCase;
    GetOrderUseCase getOrderUseCase;
    AddItemUseCase addItemUseCase;
    OrderDtoMapper mapper;

    @PostMapping
    public OrderResponse create(@RequestBody CreateOrderRequest createOrderRequest) {
        CreateOrderCommand command = mapper.toOrderCreateCommand(createOrderRequest);
        Order order = createOrderUseCase.execute(command);
        return mapper.toOrderResponse(order);
    }

    @PostMapping("/{id}/items")
    public OrderResponse addItem(@PathVariable Long id, @RequestBody AddItemRequest addItemRequest) {
        AddItemCommand command = mapper.toAddItemCommand(id, addItemRequest);
        Order order = addItemUseCase.execute(id, command);
        return mapper.toOrderResponse(order);
    }

    @GetMapping("/{id}")
    public OrderResponse read(@PathVariable Long id) {
        Order order = getOrderUseCase.execute(id);
        return mapper.toOrderResponse(order);
    }

    @PostMapping("/{id}/pay")
    public OrderResponse pay(@PathVariable Long id){
        Order order = payOrderUseCase.execute(id);
        return mapper.toOrderResponse(order);
    }
}