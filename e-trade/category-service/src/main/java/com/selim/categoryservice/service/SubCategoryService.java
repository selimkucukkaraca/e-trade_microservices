package com.selim.categoryservice.service;

import com.selim.categoryservice.repository.SubCategoryRepository;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.category.SubCategory;
import com.selim.shared.category.SubCategoryDto;
import com.selim.shared.category.converter.SubCategoryConverter;
import com.selim.shared.category.request.CreateSubCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;
    private final SubCategoryConverter subCategoryConverter;


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

    public void delete(String subCategoryName) {
        var subCategory = getBySubCategoryName(subCategoryName);
        subCategoryRepository.delete(subCategory);
    }

    public SubCategory getBySubCategoryName(String subCategoryName){
        return subCategoryRepository.findBySubCategoryName(subCategoryName);
    }

    protected void updateSubCategoryName(SubCategory subCategory){
        subCategoryRepository.save(subCategory);
    }

}
