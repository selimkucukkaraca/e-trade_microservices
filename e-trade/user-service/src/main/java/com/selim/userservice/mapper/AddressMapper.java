package com.selim.userservice.mapper;

import com.selim.userservice.dto.AddressDto;
import com.selim.userservice.dto.request.CreateAddressRequest;
import com.selim.userservice.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto toDto(Address address);
    Address toEntity(CreateAddressRequest request);
}
