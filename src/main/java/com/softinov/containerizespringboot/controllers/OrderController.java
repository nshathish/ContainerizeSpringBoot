package com.softinov.containerizespringboot.controllers;

import com.softinov.containerizespringboot.entities.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final List<Order> orders = Arrays.asList(
            new Order(1L, "Order 1", "Order 1 description", 100.0),
            new Order(2L, "Order 2", "Order 2 description", 200.0),
            new Order(3L, "Order 3", "Order 3 description", 300.0)
    );


    @GetMapping
    public ResponseEntity<Iterable<Order>> getOrders() {
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Optional<Order> order = orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();

        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
