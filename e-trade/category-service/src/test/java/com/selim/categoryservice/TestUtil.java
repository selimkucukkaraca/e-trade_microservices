package com.selim.categoryservice;

import com.selim.entity.category.SubCategory;
import com.selim.shared.category.SubCategoryDto;
import com.selim.shared.category.request.CreateSubCategoryRequest;

import java.util.List;

public class TestUtil {

    public CreateSubCategoryRequest getCreateSubCategoryRequest() {
        return new CreateSubCategoryRequest("test", "test");
    }

    public List<SubCategoryDto> getSubCategoryDtoList() {
        return List.of(new SubCategoryDto("test"));
    }

    public List<SubCategory> getSubCategoryList() {
        return List.of(new SubCategory("test"));
    }
}
