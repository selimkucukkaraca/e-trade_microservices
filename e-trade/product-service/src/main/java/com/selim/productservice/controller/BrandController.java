package com.selim.productservice.controller;

import com.selim.productservice.service.BrandService;
import com.selim.shared.product.BrandDto;
import com.selim.shared.product.request.CreateBrandRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brand")
@CrossOrigin
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<BrandDto> save(@RequestBody CreateBrandRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(brandService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String brandId) {
        brandService.deleteBrandByBrandId(brandId);
        return ResponseEntity
                .noContent()
                .build();
    }
}