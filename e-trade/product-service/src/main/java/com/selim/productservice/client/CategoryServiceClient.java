package com.selim.productservice.client;

import com.selim.entity.category.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service", path = "api/v1/category-list")
public interface CategoryServiceClient {

    @GetMapping("/categoryName/{categoryName}")
    ResponseEntity<Category> getByCategoryName(@PathVariable String categoryName);
}
