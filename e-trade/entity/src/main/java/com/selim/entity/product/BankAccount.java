package com.selim.entity.product;

import com.selim.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount extends BaseEntity {

    private String cardNumber;
    private String nameAndLastname;
    private int cvv;
    private String expirationDate;
    private double balance;
}
