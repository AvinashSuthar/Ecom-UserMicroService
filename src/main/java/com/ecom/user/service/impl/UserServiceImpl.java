package com.ecom.user.service.impl;

import com.ecom.user.dtos.request.CreateUserRequest;
import com.ecom.user.dtos.response.CreateUserResponse;
import com.ecom.user.entity.User;
import com.ecom.user.exception.UserException;
import com.ecom.user.utils.PasswordHelper;
import com.ecom.user.mapper.UserMapper;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository , UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest user) {
        User existingUser = userRepository.findByEmail(user.email());
        if(existingUser != null){
            throw new UserException("User with email already exists");
        }
        User newUser = userMapper.mapToUser(user);
        newUser.setPassword(PasswordHelper.hashPassword(newUser.getPassword()));
        User createdUser = userRepository.save(newUser);
        System.out.println("User created successfully: " + createdUser.toString());
        return userMapper.mapToUserResponse(createdUser);
    }
}
