package com.selim.shared.product;

import com.selim.shared.BaseDto;
import com.selim.shared.user.UserDto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class PromoCodeDto extends BaseDto {

    private String publicId;
    private String code;
    private double amount;
    private String codeText;
    private LocalDate endDate;
    private UserDto userDto;

}