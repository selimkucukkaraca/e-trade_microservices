package com.selim.entity.product;

import com.selim.entity.BaseEntity;
import com.selim.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class PromoCode extends BaseEntity {

    private String publicId = UUID.randomUUID().toString();
    private String code;
    private double amount;
    private String codeText;
    private LocalDate endDate;
    @ManyToOne
    private User user;

    public PromoCode(String code, double amount, LocalDate endDate, User user) {
        this.code = code;
        this.amount = amount;
        this.endDate = endDate;
        this.user = user;
    }

    public PromoCode(String publicId, String code, double amount, LocalDate endDate, User user) {
        this.publicId = publicId;
        this.code = code;
        this.amount = amount;
        this.endDate = endDate;
        this.user = user;
    }
}