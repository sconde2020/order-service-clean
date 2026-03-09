package com.sconde.example.usecase.command;

import java.math.BigDecimal;

public record CreateProductCommand(String name, BigDecimal price) {
}
