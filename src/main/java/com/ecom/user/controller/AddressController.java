package com.ecom.user.controller;

import com.ecom.user.apireponse.APIResponse;
import com.ecom.user.dtos.request.CreateAddressRequest;
import com.ecom.user.dtos.response.AddressResponse;
import com.ecom.user.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/{addressId}")
    public ResponseEntity<APIResponse<AddressResponse>> getAddressById(@PathVariable Long addressId){
                AddressResponse addressResponse = addressService.getAddressById(addressId);
                return new ResponseEntity<>(new APIResponse<>(true, "Address fetched successfully", addressResponse), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse<AddressResponse>> createAddress(@RequestBody CreateAddressRequest address){
        //TODO: update userId
        AddressResponse createdAddress = addressService.createAddress(address , 1L);
        return new ResponseEntity<>(new APIResponse<>(true, "Address created successfully", createdAddress), HttpStatus.CREATED);
    }
}
