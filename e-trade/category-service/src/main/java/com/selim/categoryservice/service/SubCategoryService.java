package com.selim.categoryservice.service;

import com.selim.categoryservice.dto.SubCategoryDto;
import com.selim.categoryservice.dto.request.CreateSubCategoryRequest;
import com.selim.categoryservice.mapper.SubCategoryMapper;
import com.selim.categoryservice.model.SubCategory;
import com.selim.categoryservice.repository.SubCategoryRepository;
import com.selim.core.exception.generic.GenericExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;


    public SubCategoryDto save(CreateSubCategoryRequest request) {
        var category = categoryService.getByCategoryName(request.getCategoryName());
        var saved = SubCategoryMapper.INSTANCE.toEntity(request);

        if (subCategoryRepository.existsBySubCategoryName(saved.getSubCategoryName())) {
            throw new GenericExistException("Sub category already exist");
        }

        subCategoryRepository.save(saved);
        category.getSubCategories().add(saved);
        categoryService.updateCategory(category);
        return SubCategoryMapper.INSTANCE.toDto(saved);
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
