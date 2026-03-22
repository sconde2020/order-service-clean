package com.sconde.example.application.command;

import java.math.BigDecimal;

public record CreateProductCommand(String name, BigDecimal price) {
}
