package com.selim.shared.product.request;

import com.selim.shared.user.request.CreateAddressRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ConfirmCartRequest {

    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;
    private String cartId;
    private String userMail;
    private Optional<String> codeText;
    private CreateAddressRequest address;

}