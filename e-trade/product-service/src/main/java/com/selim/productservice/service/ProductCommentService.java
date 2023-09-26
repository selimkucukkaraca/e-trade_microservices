package com.selim.productservice.service;

import com.selim.core.exception.NotFoundException;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.productservice.dto.ProductCommentDto;
import com.selim.productservice.dto.converter.ProductCommentConverter;
import com.selim.productservice.dto.request.CreateProductCommentRequest;
import com.selim.productservice.model.ProductComment;
import com.selim.productservice.repository.ProductCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommentService {

    private final ProductCommentRepository productCommentRepository;
    private final ProductCommentConverter productCommentConverter;

    public ProductCommentDto save(CreateProductCommentRequest request) {
        var saved = productCommentConverter.toEntity(request);
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