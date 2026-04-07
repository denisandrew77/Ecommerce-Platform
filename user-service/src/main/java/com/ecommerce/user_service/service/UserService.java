package com.ecommerce.user_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user_service.dto.UserDto;
import com.ecommerce.user_service.dto.userBuilder.UserDtoBuilder;
import com.ecommerce.user_service.entity.UserEntity;
import com.ecommerce.user_service.exceptionHandling.exception.UserAlreadyExistsException;
import com.ecommerce.user_service.exceptionHandling.exception.UserNotFoundException;
import com.ecommerce.user_service.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getById(Integer id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if(foundUser.isPresent()){
            UserEntity user = foundUser.get();
            UserDtoBuilder userBuilder = new UserDtoBuilder();
            UserDto userToBeSent = userBuilder.setUsername(user.getUsername()).setEmail(user.getEmail()).setAge(user.getAge()).getUser();
            return userToBeSent;
        }
        else throw new UserNotFoundException("User not found");
    }

    public UserDto getByUsername(String username) {
        Optional<UserEntity> foundUser = userRepository.findByUsername(username);
        if(foundUser.isPresent()){
            UserEntity user = foundUser.get();
            UserDtoBuilder userBuilder = new UserDtoBuilder();
            UserDto userToBeSent = userBuilder.setId(user.getId()).setUsername(user.getUsername()).setEmail(user.getEmail()).setAge(user.getAge()).setWalletAmount(user.getWalletAmount()).getUser();
            return userToBeSent;
        }
        else throw new UserNotFoundException("User not found");
    }

    public boolean createUser(UserEntity user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new UserAlreadyExistsException("Username already exists");
        }
        else {
            userRepository.save(user);
            return true;
        }
    }

    public void deleteUser(Integer id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if(foundUser.isPresent()){
            userRepository.deleteById(id);
        }else throw new UserNotFoundException("User not found");
    }
}
