package com.selim.userservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {

    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;

}
