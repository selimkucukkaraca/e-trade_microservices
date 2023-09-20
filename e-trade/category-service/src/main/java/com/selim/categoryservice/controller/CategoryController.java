package com.selim.categoryservice.controller;

import com.selim.categoryservice.dto.CategoryDto;
import com.selim.categoryservice.dto.request.CreateCategoryRequest;
import com.selim.categoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CreateCategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String categoryName) {
        categoryService.deleteCategory(categoryName);
        return ResponseEntity
                .noContent()
                .build();
    }



}