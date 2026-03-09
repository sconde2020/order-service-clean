package com.sconde.example.interfaces.web.dto;

public record OrderItemResponse(
        Long id,
        ProductResponse product,
        int quantity) {
}
