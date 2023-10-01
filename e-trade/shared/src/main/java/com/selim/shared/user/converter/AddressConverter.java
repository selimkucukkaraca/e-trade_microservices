package com.selim.shared.user.converter;

import com.selim.entity.user.Address;
import com.selim.shared.user.AddressDto;
import com.selim.shared.user.request.CreateAddressRequest;
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