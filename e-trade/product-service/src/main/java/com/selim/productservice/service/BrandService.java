package com.selim.productservice.service;

import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.product.Brand;
import com.selim.productservice.repository.BrandRepository;
import com.selim.shared.product.BrandDto;
import com.selim.shared.product.converter.BrandConverter;
import com.selim.shared.product.request.CreateBrandRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;

    @CachePut(value = "brands", key = "#request")
    public BrandDto save(CreateBrandRequest request) {
        var saved = brandConverter.toEntity(request);
        brandRepository.save(saved);
        return brandConverter.convertToDto(saved);
    }

    @CacheEvict(value = "brands", key = "#brandId")
    public void deleteBrandByBrandId(String brandId) {
        var brand = getBrandByBrandId(brandId);
        brandRepository.delete(brand);
    }

    @Cacheable(value = "brands", key = "#brandId")
    public Brand getBrandByBrandId(String brandId) {
        return brandRepository.findBrandByBrandId(brandId)
                .orElseThrow(() -> new GenericExistException("Brand not found: " + brandId));
    }

    @Cacheable(value = "brands", key = "#brand")
    public Brand getBrandByBrand(String brand) {
        return brandRepository.findBrandByBrand(brand);
    }
}