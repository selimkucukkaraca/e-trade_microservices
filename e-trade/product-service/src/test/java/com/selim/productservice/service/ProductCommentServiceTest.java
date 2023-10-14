package com.selim.productservice.service;

import com.selim.entity.product.Product;
import com.selim.entity.product.ProductComment;
import com.selim.entity.user.User;
import com.selim.productservice.TestUtil;
import com.selim.productservice.client.UserServiceClient;
import com.selim.productservice.repository.ProductCommentRepository;
import com.selim.shared.product.ProductCommentDto;
import com.selim.shared.product.converter.ProductCommentConverter;
import com.selim.shared.product.request.CreateProductCommentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ProductCommentServiceTest extends TestUtil {

    private ProductCommentRepository productCommentRepository;
    private ProductCommentConverter productCommentConverter;
    private ProductService productService;
    private UserServiceClient userServiceClient;
    private ProductCommentService productCommentService;


    @BeforeEach
    public void setUp() {
        productCommentRepository = mock(ProductCommentRepository.class);
        productCommentConverter = mock(ProductCommentConverter.class);
        productService = mock(ProductService.class);
        userServiceClient = mock(UserServiceClient.class);
        productCommentService = new ProductCommentService(
                productCommentRepository, productCommentConverter,
                productService,userServiceClient);
    }

    @Test
    void saveProductComment_itShouldReturnProductCommentDto() {

        CreateProductCommentRequest createProductCommentRequest = getCreateProductCommentRequest();
        Product product = getProductList().get(0);
        User user = null;
        ProductComment productComment = getProductCommentList().get(0);
        ProductCommentDto productCommentDto = getProductCommentDtoList().get(0);

        when(productCommentConverter.toEntity(createProductCommentRequest,product,user)).thenReturn(productComment);
        when(productCommentRepository.save(productComment)).thenReturn(productComment);
        when(productCommentConverter.convertToDto(productComment)).thenReturn(productCommentDto);

        ProductCommentDto response = productCommentService.save(createProductCommentRequest); //TODO

        assertEquals(response, productCommentDto);
        verify(productCommentConverter).toEntity(createProductCommentRequest,product,user);
        verify(productCommentRepository).save(productComment);
        verify(productCommentConverter).convertToDto(productComment);

    }

    @Test
    void delete() {

        ProductComment productComment = getProductCommentList().get(0);
        String productCommentId = "test";

        when(productCommentRepository.findByProductCommentId(productCommentId)).thenReturn(Optional.ofNullable(productComment));

        productCommentService.delete(productCommentId);

        assert productComment != null;
        verify(productCommentRepository).delete(productComment);

    }

    @Test
    void getProductCommentByProductCommentId_itShouldReturnProductComment() {

        ProductComment productComment = getProductCommentList().get(0);
        String productCommentId = "test";

        when(productCommentRepository.findByProductCommentId(productCommentId)).thenReturn(Optional.ofNullable(productComment));

        ProductComment response = productCommentService.getProductCommentByProductCommentId(productCommentId);

        assertEquals(response, productComment);
        verify(productCommentRepository).findByProductCommentId(productCommentId);

    }

    @Test
    void getByProductCommentId_itShouldReturnProductCommentDto() {

        ProductComment productComment = getProductCommentList().get(0);
        ProductCommentDto productCommentDto = getProductCommentDtoList().get(0);
        String productCommentId = "test";

        when(productCommentRepository.findByProductCommentId(productCommentId)).thenReturn(Optional.ofNullable(productComment));
        assert productComment != null;
        when(productCommentConverter.convertToDto(productComment)).thenReturn(productCommentDto);

        ProductCommentDto response = productCommentService.getByProductCommentId(productCommentId);

        assertEquals(productCommentDto, response);
        verify(productCommentRepository).findByProductCommentId(productCommentId);
        verify(productCommentConverter).convertToDto(productComment);

    }

}