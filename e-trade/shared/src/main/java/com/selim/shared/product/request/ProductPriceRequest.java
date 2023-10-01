package com.selim.shared.product.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceRequest {

    private String productId;
    private double newPrice;

}
