package com.selim.entity.product;

import com.selim.entity.BaseEntity;
import com.selim.entity.category.Category;
import com.selim.entity.user.Seller;
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
public class Product extends BaseEntity {

    private String productName;
    private String productDetails;
    private double productPrice;
    private int stock;
    private String productImageUrl;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private Category category;
    private String productId = UUID.randomUUID().toString();
    @ManyToOne
    private Brand brand;

    public Product(String productName, String productDetails,
                   double productPrice, int stock, String productImageUrl,
                   Brand brand, Category category) {
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
        this.brand = brand;
        this.category = category;
    }

    public Product(String productName) {
        this.productName = productName;
    }
}