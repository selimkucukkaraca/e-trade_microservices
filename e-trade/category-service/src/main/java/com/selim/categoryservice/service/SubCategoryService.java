package com.selim.categoryservice.service;

import com.selim.categoryservice.repository.SubCategoryRepository;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.category.SubCategory;
import com.selim.shared.category.SubCategoryDto;
import com.selim.shared.category.converter.SubCategoryConverter;
import com.selim.shared.category.request.CreateSubCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;
    private final SubCategoryConverter subCategoryConverter;

    @CachePut(value = "subCategories", key = "#request")
    public SubCategoryDto save(CreateSubCategoryRequest request) {
        var category = categoryService.getByCategoryName(request.getCategoryName());
        var saved = subCategoryConverter.toEntity(request);

        if (subCategoryRepository.existsBySubCategoryName(saved.getSubCategoryName())) {
            throw new GenericExistException("Sub category already exist");
        }

        subCategoryRepository.save(saved);
        category.getSubCategories().add(saved);
        categoryService.updateCategory(category);
        return subCategoryConverter.convertToDto(saved);
    }

    @CacheEvict(value = "subCategories", key = "#subCategoryName")
    public void delete(String subCategoryName) {
        var subCategory = getBySubCategoryName(subCategoryName);
        subCategoryRepository.delete(subCategory);
    }

    @Cacheable(value = "subCategories", key = "#subCategoryName")
    public SubCategory getBySubCategoryName(String subCategoryName){
        return subCategoryRepository.findBySubCategoryName(subCategoryName);
    }
}
