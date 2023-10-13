package com.selim.productservice.service;

import com.selim.entity.product.Brand;

import com.selim.productservice.repository.ProductRepository;
import com.selim.shared.product.ProductDto;
import com.selim.shared.product.converter.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductListService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final BrandService brandService;

    @Cacheable(value = "productLists", key = "#productName")
    public List<ProductDto> getProductByProductName(String productName) {
        return productRepository.findByProductName(productName)
                .stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "productLists", key = "#min and #max")
    public List<ProductDto> getProductByProductPrice(double min, double max) {
        return productRepository.findAll()
                .stream()
                .filter((product) ->
                        product.getProductPrice() >= min && product.getProductPrice() <= max
                )
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "productLists", key = "#brand")
    public List<ProductDto> getProductByProductBrand(String brand) {
        Brand fromDbBrand = brandService.getBrandByBrand(brand);
        return productRepository.findByBrand(fromDbBrand)
                .stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

}