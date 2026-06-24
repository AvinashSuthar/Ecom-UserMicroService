package com.ecom.user.service;

import com.ecom.user.dtos.request.CreateUserRequest;
import com.ecom.user.dtos.response.CreateUserResponse;
import com.ecom.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    CreateUserResponse createUser(CreateUserRequest user);
}
