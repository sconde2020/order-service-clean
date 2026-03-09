package com.sconde.example.usecase.command;

public record AddItemCommand(
        Long orderId,
        Long productId,
        int quantity) {

}
