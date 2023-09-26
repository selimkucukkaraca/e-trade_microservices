package com.selim.categoryservice.service;

import com.selim.categoryservice.dto.CategoryDto;
import com.selim.categoryservice.dto.converter.CategoryConverter;
import com.selim.categoryservice.repository.CategoryRepository;
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