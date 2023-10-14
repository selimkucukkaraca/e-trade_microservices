package com.selim.productservice.service;

import com.selim.entity.product.Product;
import com.selim.productservice.TestUtil;
import com.selim.productservice.client.CategoryServiceClient;
import com.selim.productservice.repository.ProductRepository;
import com.selim.shared.product.ProductDto;
import com.selim.shared.product.converter.ProductConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest extends TestUtil {

    private ProductRepository productRepository;
    private ProductConverter productConverter;
    private BrandService brandService;
    private CategoryServiceClient categoryServiceClient;
    private ProductService productService;

    @BeforeEach
    public void setUp(){
        productRepository = mock(ProductRepository.class);
        productConverter = mock(ProductConverter.class);
        brandService = mock(BrandService.class);
        categoryServiceClient = mock(CategoryServiceClient.class);
        productService = new ProductService(productRepository,productConverter,brandService,categoryServiceClient);
    }

    @Test
    void saveProduct_itShouldReturnProductDto(){
        //TODO
    }

    @Test
    void getByProductId_itShouldReturnProductDto() {

        Product product = getProductList().get(0);
        ProductDto productDto = getProductDtoList().get(0);
        String productId = "test";

        when(productRepository.findByProductId(productId)).thenReturn(Optional.ofNullable((product)));
        assert product != null;
        when(productConverter.convertToDto(product)).thenReturn(productDto);

        ProductDto response = productService.getByProductId(productId);

        assertEquals(response, productDto);
        verify(productRepository).findByProductId(productId);
        verify(productConverter).convertToDto(product);

    }

    @Test
    void getProductObjectByProductId_itShouldReturnProduct() {

        Product product = getProductList().get(0);
        String productId = "test";

        when(productRepository.findByProductId(productId)).thenReturn(Optional.ofNullable(product));

        Product response = productService.getProductObjectByProductId(productId);

        assertEquals(response, product);
        verify(productRepository).findByProductId(productId);

    }

    @Test
    void updateProduct() {

        Product product = getProductList().get(0);

        when(productRepository.save(product)).thenReturn(product);

        productService.updateProduct(product);

        verify(productRepository).save(product);

    }

    @Test
    void delete() {

        Product product = getProductList().get(0);
        String productId = "test";

        when(productRepository.findByProductId(productId)).thenReturn(Optional.ofNullable(product));

        productService.deleteByProductId(productId);

        assert product != null;
        verify(productRepository).delete(product);

    }

}