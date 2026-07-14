package com.ecom.user.mapper;

import com.ecom.user.dtos.request.CreateAddressRequest;
import com.ecom.user.dtos.response.AddressResponse;
import com.ecom.user.entity.Address;

public class AddressMapper {
    public static AddressResponse mapToAddressResponse(Address address){
        return new AddressResponse(
                address.getAddressId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode(),
                address.getCountry()
        );
    }
    public static Address mapToAddress(CreateAddressRequest createAddressRequest){

        Address address =  new Address();
        address.setCity(createAddressRequest.city());
        address.setCountry(createAddressRequest.country());
        address.setStreet(createAddressRequest.street());
        address.setPostalCode(createAddressRequest.postalCode());
        address.setState(createAddressRequest.state());

        //TODO:userid update
        return address;
    }
}
