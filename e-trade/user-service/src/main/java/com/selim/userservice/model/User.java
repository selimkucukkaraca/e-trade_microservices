package com.selim.userservice.model;

import com.selim.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    private String username;
    private String password;
    private String mail;
    private String imageUrl;
    private boolean isActive = false;
    //@OneToOne
    //private ConfirmCode confirmCode;
    // @OneToMany
    //@ToString.Exclude
    //private List<Address> address;
}
