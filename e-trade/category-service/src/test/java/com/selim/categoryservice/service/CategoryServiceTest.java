package com.selim.categoryservice.service;

import com.selim.categoryservice.TestUtil;
import com.selim.categoryservice.repository.CategoryRepository;
import com.selim.entity.category.Category;
import com.selim.shared.category.CategoryDto;
import com.selim.shared.category.converter.CategoryConverter;
import com.selim.shared.category.request.CreateCategoryRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CategoryServiceTest extends TestUtil {

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        categoryRepository = mock(CategoryRepository.class);
        categoryConverter = mock(CategoryConverter.class);
        categoryService = new CategoryService(categoryRepository, categoryConverter);
    }

    @Test
    void saveCategory_itShouldReturnCategoryDto() {

        CreateCategoryRequest request = getCreateCategoryRequest();
        Category category = getCategoryList().get(0);
        CategoryDto categoryDto = getCategoryDtoList().get(0);

        when(categoryConverter.toEntity(request)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryConverter.convertToDto(category)).thenReturn(categoryDto);
        when(categoryRepository.existsByCategoryName("test")).thenReturn(false);

        CategoryDto response = categoryService.save(request);

        assertEquals(response, categoryDto);

        verify(categoryConverter).toEntity(request);
        verify(categoryRepository).save(category);
        verify(categoryConverter).convertToDto(category);
        verify(categoryRepository).existsByCategoryName("test");

    }

    @Test
    void getByCategoryName_itShouldReturnCategory() {

        Category category = getCategoryList().get(0);
        String categoryName = "test";

        when(categoryRepository.findByCategoryName(categoryName)).thenReturn(Optional.ofNullable(category));

        Category response = categoryService.getByCategoryName(categoryName);

        assertEquals(response, category);
        verify(categoryRepository).findByCategoryName(categoryName);

    }

    @Test
    void delete() {

        Category category = getCategoryList().get(0);
        String categoryName = "Test";

        when(categoryRepository.findByCategoryName(categoryName)).thenReturn(Optional.ofNullable(category));

        categoryService.deleteCategory(categoryName);

        verify(categoryRepository).delete(Objects.requireNonNull(category));

    }

    @Test
    void updateCategory() {

        Category category = getCategoryList().get(0);

        when(categoryRepository.save(category)).thenReturn(category);

        categoryService.updateCategory(category);

        verify(categoryRepository).save(category);

    }

}