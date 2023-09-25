package com.selim.categoryservice.dto.converter;

import com.selim.categoryservice.dto.CategoryDto;
import com.selim.categoryservice.dto.request.CreateCategoryRequest;
import com.selim.categoryservice.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDto convertToDto(Category from) {
        return new CategoryDto(
                from.getCategoryName()
        );
    }

    public Category toEntity(CreateCategoryRequest request) {
        return new Category(
                request.getCategoryName()
        );
    }
}