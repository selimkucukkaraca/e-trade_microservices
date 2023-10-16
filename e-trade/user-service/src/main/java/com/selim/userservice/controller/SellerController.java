package com.selim.userservice.controller;

import com.selim.shared.user.SellerDto;
import com.selim.shared.user.request.CreateSellerRequest;
import com.selim.userservice.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/seller")
@CrossOrigin
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerDto> save(@RequestBody @Valid CreateSellerRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sellerService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String mail) {
        sellerService.delete(mail);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("/send-confirm-code")
    public ResponseEntity<Void> sendConfirmCode(@RequestParam String mail) {
        sellerService.sendConfirmCode(mail);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PatchMapping("/active-seller")
    public ResponseEntity<SellerDto> activateSeller(@RequestParam String mail, @RequestParam int code) {
        return ResponseEntity
                .ok(sellerService.activeSeller(mail, code));
    }

    @PatchMapping("/deActive-seller")
    public ResponseEntity<SellerDto> deActiveSeller(@RequestParam String mail) {
        return ResponseEntity
                .ok(sellerService.deActivateSeller(mail));
    }

    @GetMapping("/{mail}")
    public ResponseEntity<SellerDto> getByMail(@PathVariable String mail) {
        return ResponseEntity
                .ok(sellerService.getByMail(mail));
    }
}