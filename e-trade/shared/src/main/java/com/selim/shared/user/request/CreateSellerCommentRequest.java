package com.selim.shared.user.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class CreateSellerCommentRequest {

    private String title;
    private String body;
    @Min(value = 1, message = "Invalid star value")
    @Max(value = 5, message = "Invalid star value")
    private int star;
    private String sellerMail;
    private String userMail;

}