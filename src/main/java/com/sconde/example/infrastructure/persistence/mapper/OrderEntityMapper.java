package com.sconde.example.infrastructure.persistence.mapper;

import com.sconde.example.domain.model.Order;
import com.sconde.example.infrastructure.persistence.entity.OrderEntity;
import com.sconde.example.infrastructure.persistence.entity.OrderItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderEntityMapper {

    private final OrderItemEntityMapper orderItemEntityMapper;

    public OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity(
            order.getId(),
            order.getCustomerId(),
            order.getStatus()
        );

        List<OrderItemEntity> items = order.getItems().stream()
            .map(item -> orderItemEntityMapper.toEntity(item, orderEntity))
            .toList();

        orderEntity.setItems(items);
        return orderEntity;

    }

    public Order toDomain(OrderEntity entity) {
        return new Order(
            entity.getId(),
            entity.getCustomerId(),
            entity.getStatus(),
            entity.getItems().stream().map(orderItemEntityMapper::toDomain).toList()
        );
    }
}