package com.selim.shared.product.converter;

import com.selim.entity.category.Category;
import com.selim.entity.product.Brand;
import com.selim.entity.product.Product;
import com.selim.shared.product.ProductDto;
import com.selim.shared.product.request.CreateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private final BrandConverter brandConverter;


    public ProductConverter(BrandConverter brandConverter) {
        this.brandConverter = brandConverter;
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

    public Product toEntity(CreateProductRequest request, Brand brand, Category category) {
       Product product = new Product();
       product.setProductName(request.getProductName());
       product.setProductDetails(request.getProductDetails());
       product.setProductPrice(request.getProductPrice());
       product.setStock(request.getStock());
       product.setProductImageUrl(request.getProductImageUrl());
       product.setBrand(brand);
       product.setCategory(category);
       return product;
    }
}