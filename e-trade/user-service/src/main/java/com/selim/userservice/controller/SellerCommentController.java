package com.selim.userservice.controller;

import com.selim.shared.user.SellerCommentDto;
import com.selim.shared.user.request.CreateSellerCommentRequest;
import com.selim.userservice.service.SellerCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/seller-comment")
@CrossOrigin
@RequiredArgsConstructor
public class SellerCommentController {

    private final SellerCommentService sellerCommentService;

    @PostMapping
    public ResponseEntity<SellerCommentDto> save(@RequestBody @Valid CreateSellerCommentRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sellerCommentService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String sellerCommentId) {
        sellerCommentService.delete(sellerCommentId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{sellerCommentId}")
    public ResponseEntity<SellerCommentDto> getSellerBySellerCommentId(@PathVariable String sellerCommentId) {
        return ResponseEntity
                .ok(sellerCommentService.getSellerBySellerCommentId(sellerCommentId));
    }
}