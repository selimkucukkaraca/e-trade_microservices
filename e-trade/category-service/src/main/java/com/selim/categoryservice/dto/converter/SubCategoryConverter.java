package com.selim.categoryservice.dto.converter;

import com.selim.categoryservice.dto.SubCategoryDto;
import com.selim.categoryservice.dto.request.CreateSubCategoryRequest;
import com.selim.categoryservice.model.SubCategory;
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