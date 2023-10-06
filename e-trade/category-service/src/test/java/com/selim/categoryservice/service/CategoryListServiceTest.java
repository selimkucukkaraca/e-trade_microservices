package com.selim.categoryservice.service;

import com.selim.categoryservice.TestUtil;
import com.selim.categoryservice.repository.CategoryRepository;
import com.selim.entity.category.Category;
import com.selim.shared.category.CategoryDto;
import com.selim.shared.category.converter.CategoryConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CategoryListServiceTest extends TestUtil {

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;
    private CategoryListService categoryListService;

    @BeforeEach
    public void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        categoryConverter = mock(CategoryConverter.class);
        categoryListService = new CategoryListService(categoryRepository, categoryConverter);
    }

    @Test
    public void getCategoryByCategoryName_itShouldReturnCategoryDto() {

        CategoryDto categoryDto = getCategoryDtoList().get(0);
        Category category = getCategoryList().get(0);
        String categoryName = "test";

        when(categoryConverter.convertToDto(category)).thenReturn(categoryDto);
        when(categoryRepository.findByCategoryName(categoryName)).thenReturn(Optional.of(category));

        CategoryDto response = categoryListService.getCategoryByCategoryName(categoryName);

        assertEquals(response, categoryDto);
        verify(categoryConverter).convertToDto(category);
        verify(categoryRepository).findByCategoryName(categoryName);

    }

    @Test
    public void getByCategoryName_itShouldReturnCategory(){
        Category category = getCategoryList().get(0);
        String categoryName = "test";

        when(categoryRepository.findByCategoryName(categoryName)).thenReturn(Optional.ofNullable(category));

        Category response = categoryListService.getByCategoryName(categoryName);

        assertEquals(response, category);
        verify(categoryRepository).findByCategoryName(categoryName);
    }
}