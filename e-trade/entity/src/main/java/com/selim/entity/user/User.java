package com.selim.entity.user;

import com.selim.entity.BaseEntity;
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

    public User(Long id, String username, String password, String mail, String imageUrl, boolean isActive, ConfirmCode confirmCode, List<Address> address) {
        super.setId(id);
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.imageUrl = imageUrl;
        this.isActive = isActive;
        this.confirmCode = confirmCode;
        this.address = address;
    }

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
