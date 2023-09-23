package com.selim.userservice.repository;

import com.selim.userservice.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findBankAccountByCardNumber(String cardNumber);
}