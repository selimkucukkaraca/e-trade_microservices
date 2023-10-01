package com.selim.categoryservice.service;

import com.selim.categoryservice.repository.CategoryRepository;
import com.selim.shared.category.CategoryDto;
import com.selim.shared.category.converter.CategoryConverter;
import org.springframework.stereotype.Service;

@Service
public class CategoryListService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryListService(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    public CategoryDto getCategoryByCategoryName(String categoryName) {
        return categoryConverter.convertToDto(categoryRepository.findByCategoryName(categoryName));
    }
}