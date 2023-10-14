package com.selim.shared.product.request;

import com.selim.shared.constant.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductCommentRequest {

    private String title;
    private String body;
    @Min(value = 1, message = ErrorMessage.STAR_REQUEST_ERROR_MESSAGE)
    @Max(value = 5, message = ErrorMessage.STAR_REQUEST_ERROR_MESSAGE)
    private int star;
    private String userMail;
    private String productId;

}