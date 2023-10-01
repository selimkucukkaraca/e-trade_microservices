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
public class SellerDto extends BaseDto {

    private String username;
    private String mail;
    private String imageUrl;
    private boolean isActive;

}