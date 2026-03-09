package com.sconde.example.interfaces.web.mapper;

import com.sconde.example.domain.model.Order;
import com.sconde.example.interfaces.web.dto.AddItemRequest;
import com.sconde.example.interfaces.web.dto.CreateOrderRequest;
import com.sconde.example.interfaces.web.dto.OrderResponse;
import com.sconde.example.usecase.command.AddItemCommand;
import com.sconde.example.usecase.command.CreateOrderCommand;
import com.sconde.example.usecase.command.CreateOrderItemCommand;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper {

    public OrderResponse toOrderResponse(Order order) {
        return  new OrderResponse(
            order.getId(),
            order.getCustomerId(),
            order.getStatus().name(),
            order.getItems()
        );
    }

    public CreateOrderCommand toOrderCreateCommand(CreateOrderRequest request) {
        return new CreateOrderCommand(
                request.customerId(),
                request.items()
                        .stream()
                        .map(item -> new CreateOrderItemCommand(item.productId(), item.quantity()))
                        .toList()
        );
    }

    public AddItemCommand toAddItemCommand(Long orderId, AddItemRequest request) {
        return new AddItemCommand(orderId, request.productId(), request.quantity());
    }

}
