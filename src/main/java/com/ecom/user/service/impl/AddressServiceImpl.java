package com.ecom.user.service.impl;

import com.ecom.user.dtos.request.CreateAddressRequest;
import com.ecom.user.dtos.response.AddressResponse;
import com.ecom.user.entity.Address;
import com.ecom.user.entity.User;
import com.ecom.user.exception.NoResourceFoundException;
import com.ecom.user.mapper.AddressMapper;
import com.ecom.user.repository.AddressRepository;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository , UserRepository userRepository){
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AddressResponse getAddressById(Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        System.out.println("Address: " + address.get().getUser());
        return AddressMapper.mapToAddressResponse(address.get());
    }

    @Override
    public AddressResponse createAddress(CreateAddressRequest address, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoResourceFoundException("User with id " + userId + " not found"));
        Address newAddress = AddressMapper.mapToAddress(address);
        newAddress.setUser(user);
        return AddressMapper.mapToAddressResponse(addressRepository.save(newAddress));
    }
}
