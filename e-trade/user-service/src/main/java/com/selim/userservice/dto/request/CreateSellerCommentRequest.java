package com.selim.userservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class CreateSellerCommentRequest {

    private String title;
    private String body;
    @Min(value = 1, message = "Invalid star value")//TODO static util
    @Max(value = 5, message = "Invalid star value")
    private int star;
    private String sellerMail;
    private String userMail;

}