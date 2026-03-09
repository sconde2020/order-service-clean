package com.sconde.example.usecase;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.model.Product;
import com.sconde.example.domain.repository.OrderRepository;
import com.sconde.example.domain.repository.ProductRepository;
import com.sconde.example.usecase.command.AddItemCommand;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class AddItemUseCase {

    OrderRepository orderRepository;
    ProductRepository productRepository;

    public Order execute(Long orderId, AddItemCommand command) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(command.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        order.addItem(product, command.quantity());

        return orderRepository.save(order);
    }
}