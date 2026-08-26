package com.ecom.user.controller;

import com.ecom.user.apireponse.APIResponse;
import com.ecom.user.dtos.request.CreateAddressRequest;
import com.ecom.user.dtos.request.CreateUserRequest;
import com.ecom.user.dtos.response.CreateUserResponse;
import com.ecom.user.entity.User;
import com.ecom.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        List<User>  users = userService.getUsers();
        return users;
    }

    @PostMapping
    public ResponseEntity<APIResponse<CreateUserResponse>> createUser(@RequestBody CreateUserRequest user){
        CreateUserResponse createdUser = userService.createUser(user);
        return new ResponseEntity<>(new APIResponse<>(true, "User created successfully", createdUser), HttpStatus.CREATED);
    }

}
