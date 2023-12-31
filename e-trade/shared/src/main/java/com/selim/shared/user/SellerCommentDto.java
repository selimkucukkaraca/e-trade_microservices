package com.selim.shared.user;

import com.selim.shared.BaseDto;
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