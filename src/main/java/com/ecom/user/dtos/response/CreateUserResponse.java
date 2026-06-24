package com.ecom.user.dtos.response;

public record CreateUserResponse(
        String username,
        String email,
        String mobileNo
) {
}
