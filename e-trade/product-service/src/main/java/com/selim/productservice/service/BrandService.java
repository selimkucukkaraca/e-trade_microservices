package com.selim.productservice.service;

import com.selim.core.exception.NotFoundException;
import com.selim.entity.product.Brand;
import com.selim.productservice.dto.BrandDto;
import com.selim.productservice.dto.converter.BrandConverter;
import com.selim.productservice.dto.request.CreateBrandRequest;
import com.selim.productservice.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;

    public BrandDto save(CreateBrandRequest request) {
        var saved = brandConverter.toEntity(request);
        brandRepository.save(saved);
        return brandConverter.convertToDto(saved);
    }

    public void deleteBrandByBrandId(String brandId) {
        var brand = getBrandByBrandId(brandId);
        brandRepository.delete(brand);
    }

    public Brand getBrandByBrandId(String brandId) {
        return brandRepository.findBrandByBrandId(brandId)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public Brand getBrandByBrand(String brand) {
        return brandRepository.findBrandByBrand(brand);
    }
}