package com.selim.shared.product;

import com.selim.shared.BaseDto;
import com.selim.shared.user.UserDto;
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