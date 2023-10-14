package com.selim.productservice.service;

import com.selim.entity.product.PromoCode;
import com.selim.entity.user.User;
import com.selim.productservice.client.UserServiceClient;
import com.selim.productservice.repository.PromoCodeRepository;
import com.selim.shared.product.PromoCodeDto;
import com.selim.shared.product.converter.PromoCodeConverter;
import com.selim.shared.product.request.CreatePromoCodeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;
    private final PromoCodeConverter promoCodeConverter;
    private final UserServiceClient userServiceClient;

    @CachePut(value = "promoCodes", key = "#request")
    public PromoCodeDto save(CreatePromoCodeRequest request) {
        User fromDbUser = userServiceClient.getByMail(request.getUserMail()).getBody();
        PromoCode promoCode = new PromoCode(
                request.getCode(),
                request.getAmount(),
                request.getEndDate(),
                fromDbUser
        );

        String codeText = request.getCode() + String.valueOf(request.getAmount());
        promoCode.setCodeText(codeText);

        promoCodeRepository.save(promoCode);
        assert fromDbUser != null;
        return promoCodeConverter.convertToDto(promoCode,fromDbUser);
    }

    @Cacheable(value = "promoCodes", key = "#publicId")
    public PromoCode getByPublicId(String publicId) {
        return promoCodeRepository.findByPublicId(publicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "promo code not found: " + publicId));
    }

    @CacheEvict(value = "promoCodes", key = "#publicId")
    public void delete(String publicId) {
        PromoCode fromDbCode = getByPublicId(publicId);
        promoCodeRepository.delete(fromDbCode);
    }

    @Cacheable(value = "promoCodes", key = "#codeText")
    public PromoCode getByCodeText(String codeText) {
        return promoCodeRepository.findByCodeText(codeText)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "promo code not found"));
    }

}