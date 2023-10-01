package com.selim.productservice.controller;

import com.selim.productservice.service.CartService;
import com.selim.shared.product.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> save(@RequestParam String mail, @RequestParam String productId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cartService.save(mail, productId));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteByCartId(@RequestParam String cartId) {
        cartService.deleteByCartId(cartId);
        return ResponseEntity
                .noContent()
                .build();
    }
}