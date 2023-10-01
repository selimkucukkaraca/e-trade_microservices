package com.selim.productservice.service;

import com.selim.entity.product.Brand;

import com.selim.productservice.repository.ProductRepository;
import com.selim.shared.product.ProductDto;
import com.selim.shared.product.converter.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductListService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final BrandService brandService;


    public List<ProductDto> getProductByProductName(String productName) {
        return productRepository.findProductByProductName(productName)
                .stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductByProductPrice(double min, double max) {
        return productRepository.findAll()
                .stream()
                .filter((product) ->
                        product.getProductPrice() >= min && product.getProductPrice() <= max
                )
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductByProductBrand(String brand) {
        Brand fromDbBrand = brandService.getBrandByBrand(brand);
        return productRepository.getProductByBrand(fromDbBrand)
                .stream()
                .map(productConverter::convertToDto)
                .collect(Collectors.toList());
    }

}