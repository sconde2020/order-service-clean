package com.sconde.example.usecase;

import com.sconde.example.domain.model.Product;
import com.sconde.example.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class GetAllProductsUseCase {

    ProductRepository repository;

    public List<Product> execute() {
        return repository.findAll();
    }

}
