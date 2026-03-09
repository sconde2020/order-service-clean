package com.sconde.example.infrastructure.persistence.mapper;

import com.sconde.example.domain.model.OrderItem;
import com.sconde.example.infrastructure.persistence.entity.OrderEntity;
import com.sconde.example.infrastructure.persistence.entity.OrderItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemEntityMapper {

    private final ProductEntityMapper productEntityMapper;

    public OrderItem toDomain(OrderItemEntity entity) {
        return new OrderItem(
                entity.getId(),
                productEntityMapper.toDomain(entity.getProduct()),
                entity.getQuantity()
        );
    }

    public OrderItemEntity toEntity(OrderItem item, OrderEntity orderEntity) {
        return new OrderItemEntity(
                item.getId(),
                productEntityMapper.toEntity(item.getProduct()),
                item.getQuantity(),
                orderEntity
        );
    }
}
