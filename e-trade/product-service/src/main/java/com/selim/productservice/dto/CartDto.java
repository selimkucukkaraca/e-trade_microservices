package com.selim.productservice.dto;

import com.selim.core.dto.BaseDto;
import com.selim.userservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CartDto extends BaseDto {

    private List<ProductDto> productDto;
    private UserDto userDto;
    private String cartId;

    public CartDto(List<ProductDto> productDto, UserDto userDto) {
        this.productDto = productDto;
        this.userDto = userDto;
    }
}