package com.selim.userservice.mapper;

import com.selim.userservice.dto.SellerCommentDto;
import com.selim.userservice.dto.request.CreateSellerCommentRequest;
import com.selim.userservice.model.SellerComment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SellerCommentMapper {

    SellerCommentMapper INSTANCE = Mappers.getMapper(SellerCommentMapper.class);

    SellerCommentDto toDto(SellerComment sellerComment);
    SellerComment toEntity(CreateSellerCommentRequest request);
}
