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
public class AddressDto extends BaseDto {

    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;

}