package com.sconde.example.infrastructure.persistence;

import com.sconde.example.domain.model.Order;
import com.sconde.example.infrastructure.persistence.entity.OrderEntity;

public class OrderMapper {

    public static Order toDomain(OrderEntity entity){

        return new Order(
                entity.getId(),
                entity.getStatus()
        );
    }

    public static OrderEntity toEntity(Order order){

        return new OrderEntity(
                order.getId(),
                order.getStatus()
        );
    }
}