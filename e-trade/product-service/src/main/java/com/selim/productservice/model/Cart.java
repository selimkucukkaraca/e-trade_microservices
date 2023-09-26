package com.selim.productservice.model;

import com.selim.core.entity.BaseEntity;
import com.selim.userservice.model.User;
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
}