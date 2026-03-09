package com.sconde.example.usecase;

import com.sconde.example.domain.model.Product;
import com.sconde.example.domain.repository.ProductRepository;
import com.sconde.example.usecase.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class CreateProductUseCase {

    ProductRepository productRepository;

    public Product execute(CreateProductCommand command) {
        Product product = new Product(command.name(), command.price());
        return productRepository.save(product);
    }

}
