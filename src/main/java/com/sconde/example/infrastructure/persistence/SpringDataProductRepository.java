package com.sconde.example.infrastructure.persistence;

import com.sconde.example.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository
        extends JpaRepository<ProductEntity, Long> {
}
