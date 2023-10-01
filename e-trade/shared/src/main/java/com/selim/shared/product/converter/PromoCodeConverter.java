package com.selim.shared.product.converter;

import com.selim.entity.product.PromoCode;
import com.selim.entity.user.User;
import com.selim.shared.product.PromoCodeDto;
import com.selim.shared.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class PromoCodeConverter {

    public PromoCodeDto convertToDto(PromoCode from, User user) {
        PromoCodeDto promoCodeDto = new PromoCodeDto();
        promoCodeDto.setPublicId(from.getPublicId());
        promoCodeDto.setCode(from.getCode());
        promoCodeDto.setAmount(from.getAmount());
        promoCodeDto.setCodeText(from.getCodeText());
        promoCodeDto.setEndDate(from.getEndDate());
        promoCodeDto.setUserDto(new UserDto(user.getUsername(), user.getMail(), user.getImageUrl(), user.isActive()));
        return promoCodeDto;
    }

}
