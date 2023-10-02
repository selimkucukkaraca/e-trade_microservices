package com.selim.categoryservice.service;

import com.selim.categoryservice.repository.CategoryRepository;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.category.Category;
import com.selim.shared.category.CategoryDto;
import com.selim.shared.category.converter.CategoryConverter;
import com.selim.shared.category.request.CreateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @CachePut(value = "categories", key = "#request")
    public CategoryDto save(CreateCategoryRequest request){
        var saved = categoryConverter.toEntity(request);
        if (categoryRepository.existsByCategoryName(saved.getCategoryName())) {
            throw new GenericExistException("Category already exist");
        }
        categoryRepository.save(saved);
        return categoryConverter.convertToDto(saved);
    }

    @CacheEvict(value = "categories", key = "#categoryName")
    public void deleteCategory(String categoryName) {
        var category = getByCategoryName(categoryName);
        categoryRepository.delete(category);
    }

    @Cacheable(value = "categories", key = "#categoryName")
    public Category getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new GenericExistException("Category not found: " + categoryName));
    }

    protected void updateCategory(Category category) {
        categoryRepository.save(category);
    }

}
