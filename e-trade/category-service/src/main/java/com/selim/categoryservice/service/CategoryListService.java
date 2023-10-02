package com.selim.categoryservice.service;

import com.selim.categoryservice.repository.CategoryRepository;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.category.Category;
import com.selim.shared.category.CategoryDto;
import com.selim.shared.category.converter.CategoryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryListService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Cacheable(value = "categories", key = "#categoryName")
    public CategoryDto getCategoryByCategoryName(String categoryName) {
        return categoryConverter.convertToDto(categoryRepository.findByCategoryName(categoryName).get());
    }

    @Cacheable(value = "categories", key = "#categoryName")
    public Category getByCategoryName(String categoryName){
        return categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new GenericExistException("Category not found: " + categoryName));
    }
}