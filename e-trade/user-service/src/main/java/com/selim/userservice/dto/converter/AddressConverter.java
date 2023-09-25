package com.selim.userservice.dto.converter;

import com.selim.userservice.dto.AddressDto;
import com.selim.userservice.dto.request.CreateAddressRequest;
import com.selim.userservice.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public AddressDto convertToDto(Address from) {
        return new AddressDto(
                from.getCity(),
                from.getDistrict(),
                from.getStreet(),
                from.getApartmentNumber(),
                from.getPhoneNumber()
        );
    }

    public Address toEntity(CreateAddressRequest request) {
        return new Address(
                request.getCity(),
                request.getDistrict(),
                request.getStreet(),
                request.getApartmentNumber(),
                request.getPhoneNumber()
        );
    }
}