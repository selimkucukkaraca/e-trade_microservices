package com.selim.productservice.service;

import com.selim.entity.product.PromoCode;
import com.selim.productservice.repository.PromoCodeRepository;
import com.selim.shared.product.PromoCodeDto;
import com.selim.shared.product.converter.PromoCodeConverter;
import com.selim.shared.product.request.CreatePromoCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;
    private final UserService userService;
    private final PromoCodeConverter promoCodeConverter;


    public PromoCodeDto save(CreatePromoCodeRequest request) {
        PromoCode promoCode = new PromoCode(
                request.getCode(),
                request.getAmount(),
                request.getEndDate(),
                userService.getUserByMail(request.getUserMail())
        );

        String codeText = request.getCode() + String.valueOf(request.getAmount());
        promoCode.setCodeText(codeText);

        promoCodeRepository.save(promoCode);
        return promoCodeConverter.convertToDto(promoCode);
    }

    public PromoCode getByPublicId(String publicId) {
        return promoCodeRepository.findPromoCodeByPublicId(publicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "promo code not found"));
    }

    public void delete(String publicId) {
        PromoCode fromDbCode = getByPublicId(publicId);
        promoCodeRepository.delete(fromDbCode);
    }

    public PromoCode getByCodeText(String codeText) {
        return promoCodeRepository.findPromoCodeByCodeText(codeText)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "promo code not found"));
    }

}