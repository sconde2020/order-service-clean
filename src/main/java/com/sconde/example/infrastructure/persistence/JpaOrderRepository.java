package com.sconde.example.infrastructure.persistence;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.repository.OrderRepository;
import com.sconde.example.infrastructure.persistence.mapper.OrderEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final SpringDataOrderRepository repository;
    private final OrderEntityMapper mapper;

    public JpaOrderRepository(SpringDataOrderRepository repository, OrderEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Order> findById(Long id){
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Order save(Order order){
        var entity = mapper.toEntity(order);
        var saved = repository.save(entity);
        return mapper.toDomain(saved);
    }
}
