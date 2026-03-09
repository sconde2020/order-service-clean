package com.sconde.example.interfaces.web.dto;

import com.sconde.example.domain.model.OrderItem;

import java.util.List;

public record OrderResponse (
        Long id,
        String customerId,
        String status,
        List<OrderItem> items
) {
}
