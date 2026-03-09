package com.sconde.example.usecase.command;

import java.util.List;

public record CreateOrderCommand(String customerId, List<CreateOrderItemCommand> items) {
}
