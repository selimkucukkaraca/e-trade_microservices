package com.selim.productservice.dto.converter;

import com.selim.productservice.dto.PromoCodeDto;
import com.selim.productservice.model.PromoCode;
import com.selim.userservice.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class PromoCodeConverter {

    private final UserService userService;

    public PromoCodeConverter(UserService userService) {
        this.userService = userService;
    }

    public PromoCodeDto convertToDto(PromoCode from) {
        return new PromoCodeDto(
                from.getPublicId(),
                from.getCode(),
                from.getAmount(),
                from.getCodeText(),
                from.getEndDate(),
                userService.getByMail(from.getUser().getMail())
        );
    }
}
