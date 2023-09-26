package com.selim.productservice.controller;

import com.selim.productservice.dto.ConfirmedCartDto;
import com.selim.productservice.service.ConfirmedCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/confirmed-cart")
@CrossOrigin
@RequiredArgsConstructor
public class ConfirmedCardController {

    private final ConfirmedCardService confirmedCardService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ConfirmedCartDto>> getAll(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity
                .ok(confirmedCardService.getAll(page, size));
    }
}