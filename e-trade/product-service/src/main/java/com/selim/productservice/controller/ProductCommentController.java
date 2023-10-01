package com.selim.productservice.controller;

import com.selim.productservice.service.ProductCommentService;
import com.selim.shared.product.ProductCommentDto;
import com.selim.shared.product.request.CreateProductCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-comment")
@CrossOrigin
@RequiredArgsConstructor
public class ProductCommentController {

    private final ProductCommentService productCommentService;


    @PostMapping
    public ResponseEntity<ProductCommentDto> save(@RequestBody @Valid CreateProductCommentRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productCommentService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String productCommentId) {
        productCommentService.delete(productCommentId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{productCommentId}")
    public ResponseEntity<ProductCommentDto> getByProductId(@PathVariable String productCommentId) {
        return ResponseEntity
                .ok(productCommentService.getByProductCommentId(productCommentId));
    }
}