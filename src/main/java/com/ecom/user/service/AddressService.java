package com.ecom.user.service;

import com.ecom.user.dtos.request.CreateAddressRequest;
import com.ecom.user.dtos.response.AddressResponse;

public interface AddressService {

    AddressResponse getAddressById(Long addressId);

    AddressResponse createAddress(CreateAddressRequest address, Long userId);
}
