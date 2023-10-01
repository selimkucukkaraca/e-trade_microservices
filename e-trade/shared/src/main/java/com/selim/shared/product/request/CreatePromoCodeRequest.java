package com.selim.shared.product.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePromoCodeRequest {

    private String userMail;
    private String code;
    private double amount;
    private LocalDate endDate;

}