package com.selim.productservice.service;

import com.selim.productservice.TestUtil;
import com.selim.productservice.repository.ProductRepository;
import com.selim.shared.product.converter.ProductConverter;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

///TODO
class ProductListServiceTest extends TestUtil {

    private ProductRepository productRepository;
    private ProductConverter productConverter;
    private BrandService brandService;
    private ProductListService productListService;

    @BeforeEach
    public void setUp(){
        productRepository = mock(ProductRepository.class);
        productConverter = mock(ProductConverter.class);
        brandService = mock(BrandService.class);
        productListService = new ProductListService(productRepository,productConverter,brandService);
    }

}