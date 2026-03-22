package com.sconde.example.application.command;

public record AddItemCommand(
        Long orderId,
        Long productId,
        int quantity) {

}
