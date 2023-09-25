package com.selim.userservice.controller;

import com.selim.userservice.dto.AddressDto;
import com.selim.userservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@CrossOrigin
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String addressId) {
        addressService.delete(addressId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/address-id/{addressId}")
    public ResponseEntity<AddressDto> getAddressByAddressId(@PathVariable String addressId) {
        return ResponseEntity
                .ok(addressService.getAddressByAddressId(addressId));
    }

    @GetMapping("/user-mail/{mail}")
    public ResponseEntity<List<AddressDto>> getAddressListByUserMail(@PathVariable String mail) {
        return ResponseEntity
                .ok(addressService.getAddressListByUserMail(mail));
    }
}