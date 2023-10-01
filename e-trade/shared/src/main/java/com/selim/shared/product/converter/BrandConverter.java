package com.selim.shared.product.converter;

import com.selim.entity.product.Brand;
import com.selim.shared.product.BrandDto;
import com.selim.shared.product.request.CreateBrandRequest;
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