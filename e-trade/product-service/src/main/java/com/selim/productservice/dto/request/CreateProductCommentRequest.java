package com.selim.productservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static com.selim.notificationservice.service.ErrorMessage.*;

@Getter
@Setter
public class CreateProductCommentRequest {

    private String title;
    private String body;
    @Min(value = 1, message = STAR_REQUEST_ERROR_MESSAGE)
    @Max(value = 5, message = STAR_REQUEST_ERROR_MESSAGE)
    private int star;
    private String userMail;
    private String productId;

}