package com.selim.entity.user;

import com.selim.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seller extends BaseEntity {

    private String username;
    private String password;
    private String mail;
    private String imageUrl;
    private boolean isActive = false;
    @OneToOne
    private ConfirmCode confirmCode;

    public Seller(String username, String password, String mail, String imageUrl) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.imageUrl = imageUrl;
    }
}
