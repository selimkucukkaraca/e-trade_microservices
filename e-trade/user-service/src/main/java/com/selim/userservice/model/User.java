package com.selim.userservice.model;

import com.selim.core.entity.BaseEntity;
import com.selim.notificationservice.model.ConfirmCode;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @OneToOne
    private ConfirmCode confirmCode;
    @OneToMany
    @ToString.Exclude
    private List<Address> address;

    public User(String username, String password, String mail, String imageUrl) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.imageUrl = imageUrl;
    }

    public User(String mail) {
        this.mail = mail;
    }
}
