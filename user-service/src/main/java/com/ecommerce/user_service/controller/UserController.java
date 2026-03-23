package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.dto.UserDto;
import com.ecommerce.user_service.entity.UserEntity;
import com.ecommerce.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String base(){
        return "Welcome to User Service";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        UserDto user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public void createUser(@RequestBody UserEntity user) {
       userService.createUser(user);
    }

    @DeleteMapping("/users/{id}/delete")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
