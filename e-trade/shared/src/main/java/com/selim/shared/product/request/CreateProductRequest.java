package com.selim.shared.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductRequest {

    private String productName;
    private String productDetails;
    private double productPrice;
    private int stock;
    private String productImageUrl;
    private String brand;
    private String categoryName;

}
