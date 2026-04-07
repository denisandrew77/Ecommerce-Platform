package com.ecommerce.order_service.clients;

import com.ecommerce.order_service.dto.clients.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "${user.service.url}")
public interface UserClient {
    @GetMapping("/users")
    UserDto findUser(@RequestParam String username);
}
