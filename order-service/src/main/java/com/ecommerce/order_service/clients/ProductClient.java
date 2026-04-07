package com.ecommerce.order_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.order_service.dto.clients.ProductDto;

@FeignClient(name = "product-service", url = "${product.service.url}")
public interface ProductClient {
    @GetMapping("/product/{productName}/verifyAvailability/{requestedQuantity}")
    ProductDto verifyAvailability(@PathVariable String productName, @PathVariable Integer requestedQuantity);

    @PostMapping("/product/{productName}/updateQuantity/{requestedQuantity}")
    ProductDto updateQuantity(@PathVariable String productName, @PathVariable Integer requestedQuantity);
}
