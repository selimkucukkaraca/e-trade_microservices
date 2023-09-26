package com.selim.productservice.dto;

import com.selim.core.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ConfirmedCartDto extends BaseDto {

    private CartDto cartDto;
    private String cartId;

}