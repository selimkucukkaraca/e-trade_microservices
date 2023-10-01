package com.selim.entity.product;

import com.selim.entity.BaseEntity;
import com.selim.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class ConfirmedCart extends BaseEntity {

    @ManyToOne
    private Cart carts;
    private String confirmedId = UUID.randomUUID().toString();
    @ManyToOne
    private User user;

    public ConfirmedCart(Cart carts, User user) {
        this.carts = carts;
        this.user = user;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}