package com.selim.productservice.dto.request;


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