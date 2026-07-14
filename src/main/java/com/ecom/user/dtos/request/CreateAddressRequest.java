package com.ecom.user.dtos.request;

public record CreateAddressRequest(
         String street,
         String city,
         String state,
         String postalCode,
         String country
) {
}
