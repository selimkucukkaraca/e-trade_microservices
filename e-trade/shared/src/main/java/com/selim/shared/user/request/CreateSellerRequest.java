package com.selim.shared.user.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSellerRequest {

    private String username;
    private String password;
    private String mail;
    private String imageUrl;
}
