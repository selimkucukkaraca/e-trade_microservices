package com.selim.productservice.dto;

import com.selim.core.dto.BaseDto;
import com.selim.userservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PromoCodeDto extends BaseDto {

    private String publicId;
    private String code;
    private double amount;
    private String codeText;
    private LocalDate endDate;
    private UserDto userDto;

}