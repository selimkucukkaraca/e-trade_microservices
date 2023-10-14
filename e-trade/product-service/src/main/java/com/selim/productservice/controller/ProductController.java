package com.selim.productservice.controller;

import com.selim.entity.product.Product;
import com.selim.productservice.service.ProductService;
import com.selim.shared.product.ProductDto;
import com.selim.shared.product.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody CreateProductRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String productId) {
        productService.deleteByProductId(productId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getByProductId(@PathVariable String productId) {
        return ResponseEntity
                .ok(productService.getByProductId(productId));
    }

    @GetMapping("/productId")
    public ResponseEntity<Product> getProductByProductId(@RequestBody String productId) {
        return ResponseEntity
                .ok(productService.getProductByProductId(productId));
    }
}