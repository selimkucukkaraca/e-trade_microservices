package com.selim.userservice.service;

import com.selim.entity.user.Seller;
import com.selim.entity.user.SellerComment;
import com.selim.entity.user.User;
import com.selim.shared.user.SellerCommentDto;
import com.selim.shared.user.converter.SellerCommentConverter;
import com.selim.shared.user.request.CreateSellerCommentRequest;
import com.selim.userservice.TestUtil;
import com.selim.userservice.repository.SellerCommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class SellerCommentServiceTest extends TestUtil {

    private SellerCommentRepository sellerCommentRepository;
    private SellerCommentConverter sellerCommentConverter;
    private SellerService sellerService;
    private UserService userService;
    private SellerCommentService sellerCommentService;

    @BeforeEach
    public void setUp() {
        sellerCommentRepository = mock(SellerCommentRepository.class);
        sellerCommentConverter = mock(SellerCommentConverter.class);
        sellerService = mock(SellerService.class);
        userService = mock(UserService.class);
        sellerCommentService = new SellerCommentService(sellerCommentRepository,
                sellerCommentConverter, sellerService, userService);
    }

    @Test
    void saveSellerComment_itShouldReturnSellerCommentDto() {

        CreateSellerCommentRequest request = getCreateSellerCommentRequest();
        Seller fromDbSeller = getSellerList().get(0);
        User froMDbUser = getUserList().get(0);
        SellerComment sellerComment = getSellerCommentList().get(0);
        SellerCommentDto sellerCommentDto = getSellerCommentDtoList().get(0);

        when(sellerCommentConverter.toEntity(request,fromDbSeller,froMDbUser)).thenReturn(sellerComment);
        when(sellerCommentRepository.save(sellerComment)).thenReturn(sellerComment);
        when(sellerCommentConverter.convertToDto(sellerComment)).thenReturn(sellerCommentDto);

        SellerCommentDto response = sellerCommentService.save(request);
        //TODO
        assertEquals(response, sellerCommentDto);

        verify(sellerCommentConverter).toEntity(request,fromDbSeller,froMDbUser);
        verify(sellerCommentRepository).save(sellerComment);
        verify(sellerCommentConverter).convertToDto(sellerComment);

    }

    @Test
    void delete() {

        SellerComment sellerComment = getSellerCommentList().get(0);
        String sellerCommentId = "test";

        when(sellerCommentRepository.findBySellerCommentId(sellerCommentId)).thenReturn(Optional.ofNullable(sellerComment));

        sellerCommentService.delete(sellerCommentId);

        verify(sellerCommentRepository).findBySellerCommentId(sellerCommentId);

    }

    @Test
    void getSellerBySellerCommentId_itShouldReturnSellerCommentDto() {

        SellerComment sellerComment = getSellerCommentList().get(0);
        SellerCommentDto sellerCommentDto = getSellerCommentDtoList().get(0);
        String sellerCommentId = "test";

        when(sellerCommentRepository.findBySellerCommentId(sellerCommentId)).thenReturn(Optional.ofNullable(sellerComment));
        assert sellerComment != null;
        when(sellerCommentConverter.convertToDto(sellerComment)).thenReturn(sellerCommentDto);

        SellerCommentDto response = sellerCommentService.getSellerBySellerCommentId(sellerCommentId);

        assertEquals(response, sellerCommentDto);
        verify(sellerCommentRepository).findBySellerCommentId(sellerCommentId);
        verify(sellerCommentConverter).convertToDto(sellerComment);

    }
}