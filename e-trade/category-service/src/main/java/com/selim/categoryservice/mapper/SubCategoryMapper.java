package com.selim.categoryservice.mapper;

import com.selim.categoryservice.dto.SubCategoryDto;
import com.selim.categoryservice.dto.request.CreateSubCategoryRequest;
import com.selim.categoryservice.model.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SubCategoryMapper {

    SubCategoryMapper INSTANCE = Mappers.getMapper(SubCategoryMapper.class);

    SubCategoryDto toDto(SubCategory category);
    SubCategory toEntity(CreateSubCategoryRequest request);
}
