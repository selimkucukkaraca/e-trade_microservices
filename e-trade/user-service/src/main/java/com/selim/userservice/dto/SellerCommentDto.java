package com.selim.userservice.dto;

import com.selim.core.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SellerCommentDto extends BaseDto {

    private String title;
    private String body;
    private int star;
    private SellerDto sellerDto;
    private UserDto userDto;

}