package com.selim.userservice.service;

import com.selim.core.exception.NotFoundException;
import com.selim.core.exception.generic.GenericExistException;
import com.selim.userservice.model.ConfirmCode;
import com.selim.notificationservice.service.MailSendService;
import com.selim.userservice.dto.SellerDto;
import com.selim.userservice.dto.converter.SellerConverter;
import com.selim.userservice.dto.request.CreateSellerRequest;
import com.selim.userservice.model.Seller;
import com.selim.userservice.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.selim.notificationservice.service.MailConstant.CONFIRM_CODE_DESCRIPTION;
import static com.selim.notificationservice.service.MailConstant.CONFIRM_CODE_TITLE;


@Service
@RequiredArgsConstructor
public class SellerService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final SellerConverter sellerConverter;
    private final SellerRepository sellerRepository;

    public SellerDto save(CreateSellerRequest request) {
        var saved = sellerConverter.toEntity(request);
        if (sellerRepository.existsSellerByMail(saved.getMail())) {
            throw new GenericExistException("Seller already exist, mail: " + saved.getMail());
        }
        sellerRepository.save(saved);
        return sellerConverter.convertToDto(saved);
    }

    public void delete(String mail) {
        var fromSeller = getSellerByMail(mail);
        sellerRepository.delete(fromSeller);
    }

    public Seller getSellerByMail(String mail) {
        return sellerRepository.findSellerByMail(mail)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public SellerDto getByMail(String mail) {
        var fromDbSeller = sellerRepository.findSellerByMail(mail)
                .orElseThrow(() -> new NotFoundException("Mail not found: " + mail));
        return sellerConverter.convertToDto(fromDbSeller);
    }

    public SellerDto activeSeller(String mail, int code) {
        var seller = getSellerByMail(mail);

        if (seller.getConfirmCode().getCode() == code) {
            return null;
        }
        seller.setActive(true);
        confirmCodeService.deleteById(seller.getConfirmCode().getId());
        sellerRepository.save(seller);
        return sellerConverter.convertToDto(seller);
    }

    public SellerDto deActivateSeller(String mail) {
        var fromDbSeller = getSellerByMail(mail);
        fromDbSeller.setActive(false);
        sellerRepository.save(fromDbSeller);
        return sellerConverter.convertToDto(fromDbSeller);
    }

    public void sendConfirmCode(String mail) {
        var seller = getSellerByMail(mail);

        ConfirmCode confirmCode = new ConfirmCode();
        confirmCodeService.save(confirmCode);
        seller.setConfirmCode(confirmCode);
        sellerRepository.save(seller);

        String description = String.format(CONFIRM_CODE_DESCRIPTION, confirmCode.getCode());
        mailSendService.sendMail(seller.getMail(), CONFIRM_CODE_TITLE, description);
    }

}
