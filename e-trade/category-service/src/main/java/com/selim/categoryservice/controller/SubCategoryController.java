package com.selim.categoryservice.controller;

import com.selim.categoryservice.service.SubCategoryService;
import com.selim.shared.category.SubCategoryDto;
import com.selim.shared.category.request.CreateSubCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sub-category")
@CrossOrigin
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<SubCategoryDto> save(@RequestBody CreateSubCategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String subCategoryName) {
        subCategoryService.delete(subCategoryName);
        return ResponseEntity
                .noContent()
                .build();
    }
}
