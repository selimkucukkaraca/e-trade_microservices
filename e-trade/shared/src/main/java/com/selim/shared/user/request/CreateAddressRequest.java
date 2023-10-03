package com.selim.shared.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAddressRequest {

    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;

}
