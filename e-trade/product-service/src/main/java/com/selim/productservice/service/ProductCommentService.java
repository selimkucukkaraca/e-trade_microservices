package com.selim.productservice.service;

import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.product.ProductComment;
import com.selim.productservice.client.UserServiceClient;
import com.selim.productservice.repository.ProductCommentRepository;
import com.selim.shared.product.ProductCommentDto;
import com.selim.shared.product.converter.ProductCommentConverter;
import com.selim.shared.product.request.CreateProductCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommentService {

    private final ProductCommentRepository productCommentRepository;
    private final ProductCommentConverter productCommentConverter;
    private final UserServiceClient userServiceClient;

    @CachePut(value = "productComments", key = "#request")
    public ProductCommentDto save(CreateProductCommentRequest request) {
        var fromDbUser = userServiceClient.getProductByProductId(request.getProductId()).getBody();
        var fromDbProduct = userServiceClient.getUserByMail(request.getUserMail()).getBody();
        var saved = productCommentConverter.toEntity(request,fromDbUser,fromDbProduct);
        if (request.getStar() < 0) {
            throw new GenericExistException("you must rating by star 0-5 ");
        }
        productCommentRepository.save(saved);
        return productCommentConverter.convertToDto(saved);
    }

    @Cacheable(value = "productComments", key = "#productCommentId")
    public ProductCommentDto getByProductCommentId(String productCommentId) {
        var productComment = productCommentRepository
                .findProductCommentByProductCommentId(productCommentId)
                .orElseThrow(() -> new GenericExistException("Product comment not found: " + productCommentId));
        return productCommentConverter.convertToDto(productComment);
    }

    @CacheEvict(value = "productComments", key = "#productCommentId")
    public void delete(String productCommentId) {
        var productComment = getProductCommentByProductCommentId(productCommentId);
        productCommentRepository.delete(productComment);
    }

    @Cacheable(value = "productComments", key = "#productCommentId")
    public ProductComment getProductCommentByProductCommentId(String productCommentId) {
        return productCommentRepository.findProductCommentByProductCommentId(productCommentId)
                .orElseThrow(() -> new GenericExistException("Product comment not found: " + productCommentId));
    }

}