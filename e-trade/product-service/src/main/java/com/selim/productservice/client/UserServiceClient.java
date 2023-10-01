package com.selim.productservice.client;

import com.selim.entity.user.Address;
import com.selim.entity.user.User;
import com.selim.shared.user.request.CreateAddressRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", path = "/v1/product")
public interface UserServiceClient {

    @GetMapping("/{mail}")
    ResponseEntity<User> getUserByMail(@RequestParam String mail);

    @PostMapping
    ResponseEntity<Address> save(@RequestBody CreateAddressRequest request);




}
