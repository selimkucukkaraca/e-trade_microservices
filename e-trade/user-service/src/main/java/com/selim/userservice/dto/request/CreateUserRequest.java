package com.selim.userservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    private String username;
    private String password;
    private String mail;
    private String imageUrl;

}