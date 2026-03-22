package com.sconde.example.application.command;

public record CreateOrderItemCommand (Long productId, int quantity) {
}
