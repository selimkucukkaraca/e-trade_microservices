package com.selim.categoryservice.controller;


import com.selim.categoryservice.dto.CategoryDto;
import com.selim.categoryservice.service.CategoryListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category-list")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryListController {

    private final CategoryListService categoryListService;

    public ResponseEntity<CategoryDto> getCategoryByCategoryName(@PathVariable String categoryName) {
        return ResponseEntity
                .ok(categoryListService.getCategoryByCategoryName(categoryName));

    }
}