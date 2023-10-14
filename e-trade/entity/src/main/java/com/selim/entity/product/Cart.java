package com.selim.entity.product;

import com.selim.entity.BaseEntity;
import com.selim.entity.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart extends BaseEntity {


    @OneToMany
    @ToString.Exclude
    private List<Product> product;
    @ManyToOne
    private User user;
    private String cartId = UUID.randomUUID().toString();

    public Cart(List<Product> product, User user) {
        this.product = product;
        this.user = user;
    }

    public Cart(Long id,List<Product> product, User user, String cartId) {
        super.setId(id);
        this.product = product;
        this.user = user;
        this.cartId = cartId;
    }
}