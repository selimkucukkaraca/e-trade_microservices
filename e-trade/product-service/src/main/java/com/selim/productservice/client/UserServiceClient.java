package com.selim.productservice.client;

import com.selim.entity.product.Product;
import com.selim.entity.user.Address;
import com.selim.entity.user.User;
import com.selim.shared.user.request.CreateAddressRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", path = "api/v1/user")
public interface UserServiceClient {

    @GetMapping("/{mail}")
    ResponseEntity<User> getByMail(@PathVariable String mail);

    //TODO: fail
    @PostMapping ResponseEntity<Address> save(@RequestBody CreateAddressRequest request);

    @GetMapping("/productId")
    ResponseEntity<Product> getProductByProductId(@RequestBody String productId);
}
