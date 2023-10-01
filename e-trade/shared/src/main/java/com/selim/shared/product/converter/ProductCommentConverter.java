package com.selim.shared.product.converter;

import com.selim.entity.product.Product;
import com.selim.entity.product.ProductComment;
import com.selim.entity.user.User;
import com.selim.shared.product.ProductCommentDto;
import com.selim.shared.product.request.CreateProductCommentRequest;
import com.selim.shared.user.converter.UserConverter;
import org.springframework.stereotype.Component;

@Component
public class ProductCommentConverter {

    private final UserConverter userConverter;
    private final ProductConverter productConverter;

    public ProductCommentConverter(UserConverter userConverter,
                                   ProductConverter productConverter) {
        this.userConverter = userConverter;
        this.productConverter = productConverter;

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

    public ProductComment toEntity(CreateProductCommentRequest request, Product product, User user) {
        ProductComment productComment = new ProductComment();
        productComment.setTitle(request.getTitle());
        productComment.setBody(request.getBody());
        productComment.setStar(request.getStar());
        productComment.setUser(user);
        productComment.setProduct(product);
        return productComment;
    }
}