package com.sconde.example.infrastructure.persistence.entity;

import com.sconde.example.domain.model.OrderStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public OrderEntity(Long id, OrderStatus status) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
