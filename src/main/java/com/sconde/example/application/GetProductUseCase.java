package com.sconde.example.application;

import com.sconde.example.domain.model.Product;
import com.sconde.example.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class GetProductUseCase {

    ProductRepository productRepository;

    public Product execute(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
    }
}
