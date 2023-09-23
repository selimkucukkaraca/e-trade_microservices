package com.selim.userservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSellerRequest {

    private String username;
    private String password;
    private String mail;
    private String imageUrl;
}
