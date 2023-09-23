package com.selim.userservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAddressRequest {

    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;

}
