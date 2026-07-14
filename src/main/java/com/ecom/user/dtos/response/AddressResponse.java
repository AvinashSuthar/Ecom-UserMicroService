package com.ecom.user.dtos.response;

public record AddressResponse(
        Long addressId,
        String street,
        String city,
        String state,
        String postalCode,
        String country
) {
}
