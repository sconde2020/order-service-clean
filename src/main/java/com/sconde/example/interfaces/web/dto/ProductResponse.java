package com.sconde.example.interfaces.web.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price) {
}
