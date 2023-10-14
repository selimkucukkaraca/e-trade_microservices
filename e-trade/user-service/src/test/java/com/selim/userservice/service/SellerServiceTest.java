package com.selim.userservice.service;

import com.selim.entity.user.Seller;
import com.selim.notificationservice.service.MailSendService;
import com.selim.shared.user.SellerDto;
import com.selim.shared.user.converter.SellerConverter;
import com.selim.shared.user.request.CreateSellerRequest;
import com.selim.userservice.TestUtil;
import com.selim.userservice.repository.SellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class SellerServiceTest extends TestUtil {

    private MailSendService mailSendService;
    private ConfirmCodeService confirmCodeService;
    private SellerConverter sellerConverter;
    private SellerRepository sellerRepository;
    private SellerService sellerService;

    @BeforeEach
    public void setUp() {
        mailSendService = mock(MailSendService.class);
        confirmCodeService = mock(ConfirmCodeService.class);
        sellerConverter = mock(SellerConverter.class);
        sellerRepository = mock(SellerRepository.class);
        sellerService = new SellerService(mailSendService, confirmCodeService, sellerConverter, sellerRepository);
    }

    @Test
    public void saveSeller_itShouldReturnSellerDto() {

        CreateSellerRequest request = getCreateSellerRequest();
        Seller seller = getSellerList().get(0);
        SellerDto sellerDto = getSellerDtoList().get(0);

        when(sellerConverter.toEntity(request)).thenReturn(seller);
        when(sellerRepository.existsSellerByMail("test")).thenReturn(false);
        when(sellerRepository.save(seller)).thenReturn(seller);
        when(sellerConverter.convertToDto(seller)).thenReturn(sellerDto);

        SellerDto response = sellerService.save(request);

        assertEquals(response, sellerDto);
        verify(sellerConverter).toEntity(request);
        verify(sellerRepository).existsSellerByMail("test");
        verify(sellerRepository).save(seller);
        verify(sellerConverter).convertToDto(seller);

    }

    @Test
    public void getByMail_itShouldReturnSellerDto() {

        Seller seller = getSellerList().get(0);
        SellerDto sellerDto = getSellerDtoList().get(0);
        String mail = "test";

        when(sellerRepository.findByMail(mail)).thenReturn(Optional.ofNullable(seller));
        assert seller != null;
        when(sellerConverter.convertToDto(seller)).thenReturn(sellerDto);

        SellerDto response = sellerService.getByMail(mail);

        assertEquals(response, sellerDto);
        verify(sellerRepository).findByMail(mail);
        verify(sellerConverter).convertToDto(seller);

    }

    @Test
    public void getSellerByMail_itShouldReturnSeller() {

        Seller seller = getSellerList().get(0);
        String mail = "test";

        when(sellerRepository.findByMail(mail)).thenReturn(Optional.ofNullable(seller));

        Seller response = sellerService.getSellerByMail(mail);

        assertEquals(response, seller);
        verify(sellerRepository).findByMail(mail);

    }

    @Test
    public void delete() {

        Seller seller = getSellerList().get(0);
        String mail = "test";

        when(sellerRepository.findByMail(mail)).thenReturn(Optional.ofNullable(seller));

        sellerService.delete(mail);

        assert seller != null;
        verify(sellerRepository).delete(seller);

    }

    @Test
    public void deActivateSeller_itShouldReturnSellerDto(){

        Seller seller = getSellerList().get(0);
        SellerDto sellerDto = getSellerDtoList().get(0);

        when(sellerRepository.save(seller)).thenReturn(seller);
        when(sellerConverter.convertToDto(seller)).thenReturn(sellerDto);
        when(sellerRepository.findByMail("test")).thenReturn(Optional.of(seller));

        SellerDto response = sellerService.deActivateSeller("test");

        assertEquals(sellerDto,response);
        verify(sellerRepository).save(seller);
        verify(sellerConverter).convertToDto(seller);
        verify(sellerRepository).findByMail("test");

    }

    @Test
    public void sendConfirmCode() {
    }

    @Test
    public void activeSeller_itShouldReturnSellerDto() {
    }

}