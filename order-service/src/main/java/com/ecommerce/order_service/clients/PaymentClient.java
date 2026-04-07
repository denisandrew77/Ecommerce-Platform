package com.ecommerce.order_service.clients;

import com.ecommerce.order_service.dto.clients.PaymentDto;
import com.ecommerce.order_service.dto.clients.PaymentStatusDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "${payment.service.url}")
public interface PaymentClient {
    @PostMapping("/payments/pay")
    PaymentStatusDto processPayment(@RequestBody PaymentDto paymentDto);
}
