package com.selim.userservice.service;

import com.selim.core.exception.NotFoundException;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.user.Seller;
import com.selim.entity.user.User;
import com.selim.shared.user.SellerCommentDto;
import com.selim.shared.user.converter.SellerCommentConverter;
import com.selim.shared.user.request.CreateSellerCommentRequest;
import com.selim.userservice.repository.SellerCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerCommentService {

    private final SellerCommentRepository sellerCommentRepository;
    private final SellerCommentConverter sellerCommentConverter;
    private final SellerService sellerService;
    private final UserService userService;

    public SellerCommentDto save(CreateSellerCommentRequest request) {
        Seller fromDbSeller = sellerService.getSellerByMail(request.getUserMail());
        User froMDbUser = userService.getUserByMail(request.getUserMail());
        var saved = sellerCommentConverter.toEntity(request,fromDbSeller,froMDbUser);
        if (request.getStar() < 0) {
            throw new GenericExistException("you must rating by star ");
        }
        sellerCommentRepository.save(saved);
        return sellerCommentConverter.convertToDto(saved);
    }

    public void delete(String sellerCommentId) {
        var fromSellerComment = sellerCommentRepository
                .findBySellerCommentId(sellerCommentId);
        sellerCommentRepository.delete(fromSellerComment.get());
    }

    public SellerCommentDto getSellerBySellerCommentId(String sellerCommentId) {
        var sellerComment = sellerCommentRepository.findBySellerCommentId(sellerCommentId)
                .orElseThrow(() -> new NotFoundException(""));
        return sellerCommentConverter.convertToDto(sellerComment);
    }
}
