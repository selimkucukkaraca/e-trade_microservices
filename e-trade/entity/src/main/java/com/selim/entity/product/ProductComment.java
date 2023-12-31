package com.selim.entity.product;

import com.selim.entity.BaseEntity;
import com.selim.entity.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductComment extends BaseEntity {


    private String title;
    private String body;
    private int star;
    @ManyToOne
    private Product product;
    private String productCommentId = UUID.randomUUID().toString();
    @ManyToOne
    private User user;

    public ProductComment(Long id,String title, String body,
                          int star, Product product, String productCommentId, User user) {
        super.setId(id);
        this.title = title;
        this.body = body;
        this.star = star;
        this.product = product;
        this.productCommentId = productCommentId;
        this.user = user;
    }

}