package com.sconde.example.application;

import com.sconde.example.domain.model.Order;
import com.sconde.example.domain.model.OrderItem;
import com.sconde.example.domain.model.Product;
import com.sconde.example.domain.repository.OrderRepository;
import com.sconde.example.domain.repository.ProductRepository;
import com.sconde.example.application.command.CreateOrderCommand;
import com.sconde.example.application.command.CreateOrderItemCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Order execute(CreateOrderCommand command) {
        List<Long> productIds = command.items().stream()
                .map(CreateOrderItemCommand::productId)
                .toList();

        List<Product> products = productRepository.findAllByIds(productIds);

        List<OrderItem> items = command.items().stream()
                .map(itemRequest -> {
                    Product product = products.stream()
                            .filter(p -> p.getId().equals(itemRequest.productId()))
                            .findFirst()
                            .orElseThrow();
                    return new OrderItem(product, itemRequest.quantity());
                })
                .toList();

        Order order = new Order(command.customerId(), items);

        return orderRepository.save(order);
    }

}
