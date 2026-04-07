package com.ecommerce.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.order_service.clients.PaymentClient;
import com.ecommerce.order_service.clients.ProductClient;
import com.ecommerce.order_service.clients.UserClient;
import com.ecommerce.order_service.dto.OrderDto;
import com.ecommerce.order_service.dto.clients.PaymentDto;
import com.ecommerce.order_service.dto.clients.PaymentStatusDto;
import com.ecommerce.order_service.dto.clients.ProductDto;
import com.ecommerce.order_service.dto.clients.UserDto;
import com.ecommerce.order_service.entity.Order;
import com.ecommerce.order_service.exceptionHandling.exception.OrderAlreadyExistsException;
import com.ecommerce.order_service.exceptionHandling.exception.PaymentFailedException;
import com.ecommerce.order_service.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private UserClient userClient;

    private ProductClient productClient;

    private PaymentClient paymentClient;

    @Autowired
    public OrderService(OrderRepository orderRepository,  UserClient userClient, ProductClient productClient, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.productClient = productClient;
        this.paymentClient = paymentClient;
    }

    public void createOrder(OrderDto orderDto) {
        if(orderRepository.findByOrderName(orderDto.getOrderName()).isPresent()) {
            throw new OrderAlreadyExistsException("Order already exists");
        }
        UserDto userDto = userClient.findUser(orderDto.getUsername());
        ProductDto productDto = productClient.verifyAvailability(orderDto.getProductName(), orderDto.getQuantity());
        PaymentDto paymentDto = new PaymentDto(orderDto.getOrderName(), userDto.getUsername(), productDto.getPrice(), userDto.getWalletAmount());
        PaymentStatusDto paymentStatus = paymentClient.processPayment(paymentDto);
        if(!paymentStatus.isSuccess()) {
            throw new PaymentFailedException("Payment failed for order " + orderDto.getOrderName());
        }
        productClient.updateQuantity(orderDto.getProductName(), orderDto.getQuantity());
        orderRepository.save(new Order(userDto.getId(), orderDto.getOrderName(), orderDto.getProductName(), productDto.getPrice(), orderDto.getQuantity(),productDto.getPrice()*orderDto.getQuantity()));
    }
}
