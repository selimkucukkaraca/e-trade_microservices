package com.selim.categoryservice.mapper;

import com.selim.categoryservice.dto.CategoryDto;
import com.selim.categoryservice.dto.request.CreateCategoryRequest;
import com.selim.categoryservice.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category category);
    Category toEntity(CreateCategoryRequest request);
}
