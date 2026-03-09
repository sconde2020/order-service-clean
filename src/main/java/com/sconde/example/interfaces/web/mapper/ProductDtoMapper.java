package com.sconde.example.interfaces.web.mapper;

import com.sconde.example.domain.model.Product;
import com.sconde.example.interfaces.web.dto.CreateProductRequest;
import com.sconde.example.interfaces.web.dto.ProductResponse;
import com.sconde.example.usecase.command.CreateProductCommand;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }

    public CreateProductCommand toCreateProductCommand(CreateProductRequest request) {
        return new CreateProductCommand(request.name(), request.price());
    }
}
