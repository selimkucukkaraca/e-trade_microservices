package com.selim.categoryservice.service;

import com.selim.categoryservice.TestUtil;
import com.selim.categoryservice.repository.SubCategoryRepository;
import com.selim.entity.category.SubCategory;
import com.selim.shared.category.converter.SubCategoryConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SubCategoryServiceTest extends TestUtil {

    private SubCategoryRepository subCategoryRepository;
    private CategoryService categoryService;
    private SubCategoryConverter subCategoryConverter;
    private SubCategoryService subCategoryService;

    @BeforeEach
    public void setUp() {
        subCategoryRepository = mock(SubCategoryRepository.class);
        categoryService = mock(CategoryService.class);
        subCategoryConverter = mock(SubCategoryConverter.class);
        subCategoryService = new SubCategoryService(subCategoryRepository, categoryService,subCategoryConverter);
    }

    @Test
    void saveSubCategory_itShouldReturnSubCategoryDto() {
        //TODO
    }

    @Test
    void delete() {

        SubCategory subCategory = getSubCategoryList().get(0);
        String subCategoryName = "test";

        when(subCategoryRepository.findBySubCategoryName(subCategoryName)).thenReturn(subCategory);

        subCategoryService.delete(subCategoryName);

        verify(subCategoryRepository).delete(subCategory);

    }

    @Test
    void getBySubCategoryName_itShouldReturnSubCategory(){

        SubCategory subCategory = getSubCategoryList().get(0);
        String subCategoryName = "test";

        when(subCategoryRepository.findBySubCategoryName(subCategoryName)).thenReturn(subCategory);

        SubCategory response = subCategoryService.getBySubCategoryName(subCategoryName);
        assertEquals(response,subCategory);
        verify(subCategoryRepository).findBySubCategoryName(subCategoryName);
    }
}