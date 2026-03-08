package com.sconde.example.infrastructure.persistence;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.repository.OrderRepository;
import com.sconde.example.infrastructure.persistence.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final SpringDataOrderRepository repository;

    public JpaOrderRepository(SpringDataOrderRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Order> findById(Long id){

        return repository.findById(id)
                .map(OrderMapper::toDomain);
    }

    @Override
    public Order save(Order order){

        OrderEntity entity =
                OrderMapper.toEntity(order);

        OrderEntity saved = repository.save(entity);

        return OrderMapper.toDomain(saved);
    }
}
