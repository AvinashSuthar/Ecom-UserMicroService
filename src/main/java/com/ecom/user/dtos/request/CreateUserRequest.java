package com.ecom.user.dtos.request;

public record CreateUserRequest(
        String username,
        String email,
        String password,
        String mobileNo
) {
}
