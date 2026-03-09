package com.sconde.example.infrastructure.persistence;

import com.sconde.example.domain.model.Product;
import com.sconde.example.domain.repository.ProductRepository;
import com.sconde.example.infrastructure.persistence.mapper.ProductEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductRepository implements ProductRepository {

    private final SpringDataProductRepository repository;
    private final ProductEntityMapper mapper;

    public JpaProductRepository(SpringDataProductRepository repository, ProductEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Product> findAllByIds(List<Long> ids) {
        return repository.findAllById(ids).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Product save(Product product) {
        var entity = mapper.toEntity(product);
        var saved = repository.save(entity);
        return mapper.toDomain(saved);
    }
}
