package com.selim.productservice.repository;

import com.selim.entity.product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByBrand(String brand);
    Optional<Brand> findByBrandId(String brandId);

}