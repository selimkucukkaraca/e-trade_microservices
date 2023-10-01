package com.selim.productservice.service;

import com.selim.core.exception.NotFoundException;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.product.ProductComment;
import com.selim.productservice.client.UserServiceClient;
import com.selim.productservice.repository.ProductCommentRepository;
import com.selim.shared.product.ProductCommentDto;
import com.selim.shared.product.converter.ProductCommentConverter;
import com.selim.shared.product.request.CreateProductCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommentService {

    private final ProductCommentRepository productCommentRepository;
    private final ProductCommentConverter productCommentConverter;
    private final UserServiceClient userServiceClient;

    public ProductCommentDto save(CreateProductCommentRequest request) {
        var fromDbUser = userServiceClient.getProductByProductId(request.getProductId()).getBody();
        var fromDbProduct = userServiceClient.getUserByMail(request.getUserMail()).getBody();
        var saved = productCommentConverter.toEntity(request,fromDbUser,fromDbProduct);
        if (request.getStar() < 0) {
            throw new GenericExistException("you must rating by star ");
        }
        productCommentRepository.save(saved);
        return productCommentConverter.convertToDto(saved);
    }

    public void delete(String productCommentId) {
        var productComment = getProductCommentByProductCommentId(productCommentId);
        productCommentRepository.delete(productComment);
    }

    public ProductComment getProductCommentByProductCommentId(String productCommentId) {
        return productCommentRepository.findProductCommentByProductCommentId(productCommentId)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public ProductCommentDto getByProductCommentId(String productCommentId) {
        var productComment = productCommentRepository
                .findProductCommentByProductCommentId(productCommentId)
                .orElseThrow(() -> new NotFoundException(""));
        return productCommentConverter.convertToDto(productComment);
    }

}