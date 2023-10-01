package com.selim.shared.user.converter;

import com.selim.entity.user.Seller;
import com.selim.entity.user.SellerComment;
import com.selim.entity.user.User;
import com.selim.shared.user.SellerCommentDto;
import com.selim.shared.user.request.CreateSellerCommentRequest;
import org.springframework.stereotype.Component;

@Component
public class SellerCommentConverter {

    private final SellerConverter sellerConverter;
    private final UserConverter userConverter;

    public SellerCommentConverter(SellerConverter sellerConverter,
                                  UserConverter userConverter) {
        this.sellerConverter = sellerConverter;
        this.userConverter = userConverter;
    }

    public SellerCommentDto convertToDto(SellerComment from) {
        return new SellerCommentDto(
                from.getTitle(),
                from.getBody(),
                from.getStar(),
                sellerConverter.convertToDto(from.getSeller()),
                userConverter.convertToDto(from.getUser())
        );
    }

    public SellerComment toEntity(CreateSellerCommentRequest request, Seller seller, User user) {
        SellerComment sellerComment = new SellerComment();
        sellerComment.setTitle(request.getTitle());
        sellerComment.setBody(request.getBody());
        sellerComment.setSeller(seller);
        sellerComment.setUser(user);
        return sellerComment;
    }
}