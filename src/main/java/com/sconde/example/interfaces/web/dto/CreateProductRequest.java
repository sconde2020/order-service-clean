package com.sconde.example.interfaces.web.dto;

import java.math.BigDecimal;

public record CreateProductRequest(String name, BigDecimal price) {
}
