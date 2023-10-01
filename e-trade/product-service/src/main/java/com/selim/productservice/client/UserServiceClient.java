package com.selim.productservice.client;

import com.selim.entity.category.Category;
import com.selim.entity.product.Product;
import com.selim.entity.user.Address;
import com.selim.entity.user.User;
import com.selim.shared.user.request.CreateAddressRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service", path = "/v1/product")
public interface UserServiceClient {

    @GetMapping("/{mail}")
    ResponseEntity<User> getUserByMail(@RequestParam String mail);

    @PostMapping
    ResponseEntity<Address> save(@RequestBody CreateAddressRequest request);

    @GetMapping("/categoryName")
    ResponseEntity<Category> getByCategoryName(@RequestBody String categoryName);

    @GetMapping("/productId")
    ResponseEntity<Product> getProductByProductId(@RequestBody String productId);
}
