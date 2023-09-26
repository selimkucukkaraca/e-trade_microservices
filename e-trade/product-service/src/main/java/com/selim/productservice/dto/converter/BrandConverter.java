package com.selim.productservice.dto.converter;

import com.selim.productservice.dto.BrandDto;
import com.selim.productservice.dto.request.CreateBrandRequest;
import com.selim.productservice.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter {

    public BrandDto convertToDto(Brand from) {
        return new BrandDto(
                from.getBrand(),
                from.getBrandId()
        );
    }

    public Brand toEntity(CreateBrandRequest request) {
        return new Brand(
                request.getBrand()
        );
    }
}