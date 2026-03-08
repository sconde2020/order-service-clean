package com.sconde.example.infrastructure.persistence;

import com.sconde.example.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderRepository
        extends JpaRepository<OrderEntity, Long> {
}
