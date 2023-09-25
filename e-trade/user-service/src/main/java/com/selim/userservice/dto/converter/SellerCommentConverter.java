package com.selim.userservice.dto.converter;

import com.selim.userservice.dto.SellerCommentDto;
import com.selim.userservice.dto.request.CreateSellerCommentRequest;
import com.selim.userservice.model.SellerComment;
import com.selim.userservice.service.SellerService;
import com.selim.userservice.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class SellerCommentConverter {

    private final SellerConverter sellerConverter;
    private final SellerService sellerService;
    private final UserConverter userConverter;
    private final UserService userService;

    public SellerCommentConverter(SellerConverter sellerConverter, SellerService sellerService,
                                  UserConverter userConverter, UserService userService) {
        this.sellerConverter = sellerConverter;
        this.sellerService = sellerService;
        this.userConverter = userConverter;
        this.userService = userService;
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

    public SellerComment toEntity(CreateSellerCommentRequest request) {
        return new SellerComment(
                request.getTitle(),
                request.getBody(),
                request.getStar(),
                sellerService.getSellerByMail(request.getSellerMail()),
                userService.getUserByMail(request.getUserMail())
        );
    }
}