package com.selim.shared.category.converter;

import com.selim.entity.category.Category;
import com.selim.shared.category.CategoryDto;
import com.selim.shared.category.request.CreateCategoryRequest;
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