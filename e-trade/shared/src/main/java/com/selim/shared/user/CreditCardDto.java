package com.selim.shared.user;

import com.selim.shared.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CreditCardDto extends BaseDto {

    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;

}