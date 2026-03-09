package com.sconde.example.domain.repository;

import com.sconde.example.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAllByIds(List<Long> ids);

    List<Product> findAll();

}
