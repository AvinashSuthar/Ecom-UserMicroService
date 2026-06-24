package com.ecom.user.mapper;

import com.ecom.user.dtos.request.CreateUserRequest;
import com.ecom.user.dtos.response.CreateUserResponse;
import com.ecom.user.entity.Role;
import com.ecom.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User mapToUser(CreateUserRequest user) {
        User userEntity = new User();
        userEntity.setEmail(user.email());
        userEntity.setPassword(user.password());
        userEntity.setMobileNo(user.mobileNo());
        userEntity.setUsername(user.username());
        List<Role> roles = new ArrayList<>();
        roles.add(Role.USER);
        userEntity.setRole(roles);
        return userEntity;
    }

    public CreateUserResponse mapToUserResponse(User user) {
        return new CreateUserResponse(
                user.getUsername(), user.getMobileNo(), user.getEmail()
        );
    }
}
