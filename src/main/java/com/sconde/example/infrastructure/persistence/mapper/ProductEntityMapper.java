package com.sconde.example.infrastructure.persistence.mapper;

import com.sconde.example.domain.model.Product;
import com.sconde.example.infrastructure.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    public ProductEntity toEntity(Product product) {
        return new ProductEntity(
            product.getId(),
            product.getName(),
            product.getPrice()
        );
    }

    public Product toDomain(ProductEntity entity) {
        return new Product(
            entity.getProductId(),
            entity.getName(),
            entity.getPrice()
        );
    }
}
