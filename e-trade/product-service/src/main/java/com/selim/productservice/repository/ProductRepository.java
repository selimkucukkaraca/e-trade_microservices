package com.selim.productservice.repository;

import com.selim.entity.product.Brand;
import com.selim.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductId(String productId);
    Optional<Product> findByBrand(Brand brand);
    List<Product> findByProductName(String productName);

}