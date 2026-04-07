package com.ecommerce.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order_service.dto.OrderDto;
import com.ecommerce.order_service.dto.responseEntity.OrderState;
import com.ecommerce.order_service.service.OrderService;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/orders/fulfillOrder")
    public ResponseEntity<OrderState> createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return new ResponseEntity<>(new OrderState(true, orderDto.getOrderName() + " has been created"), HttpStatus.CREATED);
    }
}
