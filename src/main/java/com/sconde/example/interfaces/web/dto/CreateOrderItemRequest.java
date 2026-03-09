package com.sconde.example.interfaces.web.dto;

public record CreateOrderItemRequest(Long productId, int quantity) {
}
