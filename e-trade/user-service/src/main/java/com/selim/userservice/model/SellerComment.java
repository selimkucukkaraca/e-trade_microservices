package com.selim.userservice.model;

import com.selim.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SellerComment extends BaseEntity {

    private String title;
    private String body;
    private int star;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private User user;
    private String sellerCommentId = UUID.randomUUID().toString();

    public SellerComment(String title, String body, int star, Seller seller, User user) {
        this.title = title;
        this.body = body;
        this.star = star;
        this.seller = seller;
        this.user = user;
    }
}
