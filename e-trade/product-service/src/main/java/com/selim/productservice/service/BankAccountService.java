package com.selim.productservice.service;

import com.selim.entity.product.BankAccount;
import com.selim.productservice.repository.BankAccountRepository;
import com.selim.shared.product.request.ConfirmCartRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    protected BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    protected BankAccount getByCardNumber(String cardNumber) {
        return bankAccountRepository.findByCardNumber(cardNumber);
    }

    protected boolean validateCreditCard(ConfirmCartRequest request) {
        BankAccount bankAccount = bankAccountRepository.findByCardNumber(request.getCardNumber());

        if (bankAccount.getCardNumber().equals(request.getCardNumber())
                && bankAccount.getCvv() == request.getCvv()
                && bankAccount.getNameAndLastname().equals(request.getNameAndSurname())) {
            // && bankAccount.getExpirationDate().equals(request.getExpirationDate())) {
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "card not valid");
        }
    }

}
