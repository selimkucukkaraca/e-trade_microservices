package com.selim.productservice.service;

import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.category.Category;
import com.selim.entity.product.Brand;
import com.selim.entity.product.Product;
import com.selim.productservice.client.UserServiceClient;
import com.selim.productservice.repository.ProductRepository;
import com.selim.shared.product.ProductDto;
import com.selim.shared.product.converter.ProductConverter;
import com.selim.shared.product.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final BrandService brandService;
    private final UserServiceClient userServiceClient;

    @CachePut(value = "products", key = "#request")
    public ProductDto save(CreateProductRequest request) {
        Brand fromDbBrand = brandService.getBrandByBrand(request.getBrand());
        Category category = userServiceClient.getByCategoryName(request.getCategoryName()).getBody();
        var saved = productConverter.toEntity(request,fromDbBrand,category);
        productRepository.save(saved);
        return productConverter.convertToDto(saved);
    }

    @Cacheable(value = "products", key = "#productId")
    public Product getProductObjectByProductId(String productId) {
        return productRepository.findProductByProductId(productId)
                .orElseThrow(() -> new GenericExistException("ProductId not found: " + productId));
    }

    @CacheEvict(value = "products", key = "#productId")
    public void deleteByProductId(String productId) {
        var product = getProductObjectByProductId(productId);
        productRepository.delete(product);
    }

    @Cacheable(value = "products", key = "#productId")
    public ProductDto getByProductId(String productId) {
        var fromDbProduct = productRepository.findProductByProductId(productId)
                .orElseThrow(() -> new GenericExistException("ProductId not found: " + productId));
        return productConverter.convertToDto(fromDbProduct);
    }

    @Cacheable(value = "products", key = "#productId")
    public Product getProductByProductId(String productId){
        return productRepository.findProductByProductId(productId)
                .orElseThrow(()-> new GenericExistException("ProductId not found: " + productId));
    }

    protected void updateProduct(Product product) {
        productRepository.save(product);
    }

}