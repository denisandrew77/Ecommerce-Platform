package com.ecommerce.user_service.dto.userBuilder;

import com.ecommerce.user_service.dto.UserDto;

public class UserDtoBuilder implements BaseUserDtoBuilder {

    private UserDto userDto;

    public UserDtoBuilder () {
        userDto = new UserDto();
    }

    @Override
    public UserDtoBuilder setUsername(String username) {
        this.userDto.setUsername(username);
        return this;
    }

    @Override
    public UserDtoBuilder setEmail(String email) {
        this.userDto.setEmail(email);
        return this;
    }

    @Override
    public UserDtoBuilder setPassword(String password) {
        this.userDto.setPassword(password);
        return this;
    }

    @Override
    public UserDtoBuilder setAge(int age) {
        this.userDto.setAge(age);
        return this;
    }

    @Override
    public UserDtoBuilder setWalletAmount(Double walletAmount) {
        this.userDto.setWalletAmount(walletAmount)
    }

    @Override
    public UserDto getUser() {
        return this.userDto;
    }
}
