package com.selim.productservice.model;

import com.selim.categoryservice.model.Category;
import com.selim.core.entity.BaseEntity;
import com.selim.userservice.model.Seller;
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
                   double productPrice, int stock, String productImageUrl, Category category, Brand brand) {
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
        this.category = category;
        this.brand = brand;
    }

    public Product(String productName) {
        this.productName = productName;
    }
}