package com.sconde.example.interfaces.web;

import com.sconde.example.domain.model.Product;
import com.sconde.example.interfaces.web.dto.CreateProductRequest;
import com.sconde.example.interfaces.web.dto.ProductResponse;
import com.sconde.example.interfaces.web.mapper.ProductDtoMapper;
import com.sconde.example.usecase.CreateProductUseCase;
import com.sconde.example.usecase.GetAllProductsUseCase;
import com.sconde.example.usecase.GetProductUseCase;
import com.sconde.example.usecase.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ProductController {

    CreateProductUseCase createProductUseCase;
    GetProductUseCase getProductUseCase;
    GetAllProductsUseCase getAllProductsUseCase;
    ProductDtoMapper mapper;

    @PostMapping
    public ProductResponse createProduct(CreateProductRequest request) {
        CreateProductCommand command = mapper.toCreateProductCommand(request);
        Product product = createProductUseCase.execute(command);
        return mapper.toProductResponse(product);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        Product product = getProductUseCase.execute(id);
        return mapper.toProductResponse(product);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return getAllProductsUseCase.execute().stream()
                .map(mapper::toProductResponse)
                .toList();
    }
}
