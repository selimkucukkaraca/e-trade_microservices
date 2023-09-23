package com.selim.userservice.model;

import com.selim.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

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
    //@OneToOne
    //private ConfirmCode confirmCode;
}
