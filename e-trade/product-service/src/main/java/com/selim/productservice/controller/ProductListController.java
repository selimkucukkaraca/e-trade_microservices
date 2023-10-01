package com.selim.productservice.controller;

import com.selim.productservice.service.ProductListService;
import com.selim.shared.product.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-list")
@CrossOrigin
@RequiredArgsConstructor
public class ProductListController {

    private final ProductListService productListService;

    @GetMapping("/get-by-name/{productName}")
    public ResponseEntity<List<ProductDto>> getProductByProductName(@PathVariable String productName) {
        return ResponseEntity
                .ok(productListService.getProductByProductName(productName));
    }

    @GetMapping("/get-by-brand/{brand}")
    public ResponseEntity<List<ProductDto>> getProductByProductBrand(@PathVariable String brand) {
        return ResponseEntity
                .ok(productListService.getProductByProductBrand(brand));
    }

    @GetMapping("/get-by-price")
    public ResponseEntity<List<ProductDto>> getProductByProductPrice(@RequestParam double min, @RequestParam double max) {
        return ResponseEntity
                .ok(productListService.getProductByProductPrice(min, max));
    }
}