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
public class SellerDto extends BaseDto {

    private String username;
    private String mail;
    private String imageUrl;
    private boolean isActive;

}