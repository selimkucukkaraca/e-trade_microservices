package com.selim.categoryservice;

import com.selim.entity.category.Category;
import com.selim.entity.category.SubCategory;
import com.selim.shared.category.CategoryDto;
import com.selim.shared.category.SubCategoryDto;
import com.selim.shared.category.request.CreateCategoryRequest;
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

    public CreateCategoryRequest getCreateCategoryRequest() {
        CreateCategoryRequest request = new CreateCategoryRequest();
        request.setCategoryName("test");
        return request;
    }

    public List<CategoryDto> getCategoryDtoList() {
        return List.of(new CategoryDto("test"));
    }

    public List<Category> getCategoryList() {
        return List.of(new Category(1L, "test", null));
    }

}
