package com.ecommerce.user_service.dto.userBuilder;

import com.ecommerce.user_service.dto.UserDto;

public interface BaseUserDtoBuilder {
    BaseUserDtoBuilder setId(Integer id);
    BaseUserDtoBuilder setUsername(String username);
    BaseUserDtoBuilder setEmail(String email);
    BaseUserDtoBuilder setPassword(String password);
    BaseUserDtoBuilder setAge(int age);
    BaseUserDtoBuilder setWalletAmount(Double walletAmount);
    UserDto getUser();
}
