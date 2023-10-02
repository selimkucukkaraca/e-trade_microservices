package com.selim.categoryservice.service;

import com.selim.categoryservice.TestUtil;
import com.selim.categoryservice.repository.CategoryRepository;
import com.selim.categoryservice.repository.SubCategoryRepository;
import com.selim.entity.category.SubCategory;
import com.selim.shared.category.converter.CategoryConverter;
import com.selim.shared.category.converter.SubCategoryConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SubCategoryServiceTest extends TestUtil {

    private SubCategoryRepository subCategoryRepository;
    private SubCategoryConverter subCategoryConverter;
    private CategoryService categoryService;
    private SubCategoryService subCategoryService;
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        subCategoryRepository = mock(SubCategoryRepository.class);
        subCategoryConverter = mock(SubCategoryConverter.class);
        categoryService = mock(CategoryService.class);
        subCategoryService = new SubCategoryService(subCategoryRepository,categoryService, subCategoryConverter);
        categoryRepository = mock(CategoryRepository.class);
        CategoryConverter categoryConverter = mock(CategoryConverter.class);
        categoryService = new CategoryService(categoryRepository, categoryConverter);
    }

    @Test
    public void saveSubCategory_itShouldReturnSubCategoryDto() {
    }

    @Test
    public void delete() {

        SubCategory subCategory = getSubCategoryList().get(0);
        String subCategoryName = "test";

        when(subCategoryRepository.findBySubCategoryName(subCategoryName)).thenReturn(subCategory);

        subCategoryService.delete(subCategoryName);

        verify(subCategoryRepository).delete(subCategory);

    }
}