package com.selim.userservice.mapper;

import com.selim.userservice.dto.SellerDto;
import com.selim.userservice.dto.request.CreateSellerRequest;
import com.selim.userservice.model.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SellerMapper {

    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);

    SellerDto toDto(Seller seller);
    Seller toEntity(CreateSellerRequest request);
}
