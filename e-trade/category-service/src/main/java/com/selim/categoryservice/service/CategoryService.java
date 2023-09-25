package com.selim.categoryservice.service;

import com.selim.categoryservice.dto.CategoryDto;
import com.selim.categoryservice.dto.converter.CategoryConverter;
import com.selim.categoryservice.dto.request.CreateCategoryRequest;
import com.selim.categoryservice.model.Category;
import com.selim.categoryservice.repository.CategoryRepository;
import com.selim.core.exception.generic.GenericExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryDto save(CreateCategoryRequest request){
        var saved = categoryConverter.toEntity(request);
        if (categoryRepository.existsByCategoryName(saved.getCategoryName())) {
            throw new GenericExistException("Category already exist");
        }
        categoryRepository.save(saved);
        return categoryConverter.convertToDto(saved);
    }

    public void deleteCategory(String categoryName) {
        var category = getByCategoryName(categoryName);
        categoryRepository.delete(category);
    }

    public Category getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    protected void updateCategory(Category category) {
        categoryRepository.save(category);
    }

}
