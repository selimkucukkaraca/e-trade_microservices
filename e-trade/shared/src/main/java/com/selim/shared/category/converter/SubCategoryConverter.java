package com.selim.shared.category.converter;

import com.selim.entity.category.SubCategory;
import com.selim.shared.category.SubCategoryDto;
import com.selim.shared.category.request.CreateSubCategoryRequest;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryConverter {

    public SubCategoryDto convertToDto(SubCategory from) {
        return new SubCategoryDto(
                from.getSubCategoryName()
        );
    }

    public SubCategory toEntity(CreateSubCategoryRequest request) {
        return new SubCategory(
                request.getSubCategoryName()
        );
    }
}