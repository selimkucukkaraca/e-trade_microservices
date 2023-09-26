package com.selim.productservice.controller;

import com.selim.productservice.dto.request.ConfirmCartRequest;
import com.selim.productservice.service.BuyProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/buy-product")
@CrossOrigin
@RequiredArgsConstructor
public class BuyProductController {

    private final BuyProductService buyProductService;

    @PostMapping
    public ResponseEntity<Void> buy(@RequestBody ConfirmCartRequest request) {
        buyProductService.buy(request);
        return ResponseEntity
                .noContent()
                .build();
    }
}