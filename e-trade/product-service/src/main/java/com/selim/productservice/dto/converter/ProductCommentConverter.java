package com.selim.productservice.dto.converter;

import com.selim.productservice.dto.ProductCommentDto;
import com.selim.productservice.dto.request.CreateProductCommentRequest;
import com.selim.productservice.model.ProductComment;
import com.selim.productservice.service.ProductService;
import com.selim.userservice.dto.converter.UserConverter;
import com.selim.userservice.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ProductCommentConverter {

    private final UserConverter userConverter;
    private final UserService userService;
    private final ProductConverter productConverter;
    private final ProductService productService;

    public ProductCommentConverter(UserConverter userConverter, UserService userService,
                                   ProductConverter productConverter, ProductService productService) {
        this.userConverter = userConverter;
        this.userService = userService;
        this.productConverter = productConverter;
        this.productService = productService;
    }

    public ProductCommentDto convertToDto(ProductComment from) {
        return new ProductCommentDto(
                from.getTitle(),
                from.getBody(),
                from.getStar(),
                userConverter.convertToDto(from.getUser()),
                productConverter.convertToDto(from.getProduct())
        );
    }

    public ProductComment toEntity(CreateProductCommentRequest request) {
        return new ProductComment(
                request.getTitle(),
                request.getBody(),
                request.getStar(),
                userService.getUserByMail(request.getUserMail()),
                productService.getProductObjectByProductId(request.getProductId())
        );
    }
}