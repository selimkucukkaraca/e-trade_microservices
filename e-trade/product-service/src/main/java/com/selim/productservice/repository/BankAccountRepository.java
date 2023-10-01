package com.selim.productservice.repository;

import com.selim.entity.product.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findBankAccountByCardNumber(String cardNumber);
}