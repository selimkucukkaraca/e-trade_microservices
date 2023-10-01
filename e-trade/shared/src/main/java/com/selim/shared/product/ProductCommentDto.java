package com.selim.shared.product;

import com.selim.shared.BaseDto;
import com.selim.shared.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductCommentDto extends BaseDto {

    private String title;
    private String body;
    private int star;
    private UserDto userDto;
    private ProductDto productDto;

}