package com.selim.userservice.model;

import com.selim.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard extends BaseEntity {

    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;
    @ManyToOne
    private User user;
}
