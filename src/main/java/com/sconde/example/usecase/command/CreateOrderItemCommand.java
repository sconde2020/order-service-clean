package com.sconde.example.usecase.command;

public record CreateOrderItemCommand (Long productId, int quantity) {
}
