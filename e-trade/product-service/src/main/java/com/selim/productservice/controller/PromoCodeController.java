package com.selim.productservice.controller;

import com.selim.productservice.dto.PromoCodeDto;
import com.selim.productservice.dto.request.CreatePromoCodeRequest;
import com.selim.productservice.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/promo-code")
@CrossOrigin
@RequiredArgsConstructor
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @PostMapping
    public ResponseEntity<PromoCodeDto> save(@RequestBody CreatePromoCodeRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(promoCodeService.save(request));
    }
}