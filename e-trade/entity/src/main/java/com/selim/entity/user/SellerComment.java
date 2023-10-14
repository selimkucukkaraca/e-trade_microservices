package com.selim.entity.user;

import com.selim.entity.BaseEntity;
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

    public SellerComment(Long id,String title, String body,
                         int star, Seller seller, User user, String sellerCommentId) {
        super.setId(id);
        this.title = title;
        this.body = body;
        this.star = star;
        this.seller = seller;
        this.user = user;
        this.sellerCommentId = sellerCommentId;
    }

}
