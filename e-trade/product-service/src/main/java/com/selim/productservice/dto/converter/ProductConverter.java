package com.selim.productservice.dto.converter;

import com.selim.categoryservice.service.CategoryService;
import com.selim.productservice.dto.ProductDto;
import com.selim.productservice.dto.request.CreateProductRequest;
import com.selim.productservice.model.Product;
import com.selim.productservice.service.BrandService;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private final BrandConverter brandConverter;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public ProductConverter(BrandConverter brandConverter,
                            BrandService brandService,
                            CategoryService categoryService) {
        this.brandConverter = brandConverter;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    public ProductDto convertToDto(Product from) {
        return new ProductDto(
                from.getProductName(),
                from.getProductDetails(),
                from.getProductPrice(),
                from.getStock(),
                from.getProductImageUrl(),
                from.getProductId(),
                brandConverter.convertToDto(from.getBrand())
        );
    }

    public Product toEntity(CreateProductRequest request) {
        return new Product(
                request.getProductName(),
                request.getProductDetails(),
                request.getProductPrice(),
                request.getStock(),
                request.getProductImageUrl(),
                categoryService.getByCategoryName(request.getCategoryName()),
                brandService.getBrandByBrand(request.getBrand())
        );
    }
}