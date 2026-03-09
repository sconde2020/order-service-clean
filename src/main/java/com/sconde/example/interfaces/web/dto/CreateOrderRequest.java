package com.sconde.example.interfaces.web.dto;

import java.util.List;

public record CreateOrderRequest(String customerId, List<CreateOrderItemRequest> items) {
}
