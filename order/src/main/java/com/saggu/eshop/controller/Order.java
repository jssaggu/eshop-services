package com.saggu.eshop.controller;

import com.saggu.eshop.dao.OrderDao;
import com.saggu.eshop.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class Order {

    private final OrderDao orderDao;

    public Order(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping(value = "/orders/{orderId}")
    public ResponseEntity<OrderDto> productById(@PathVariable("orderId") String orderId) {
        Optional<OrderDto> order = orderDao.getOrder(orderId);

        if (order.isPresent()) {
            return ok(order.get());
        }

        return notFound().build();
    }
}
