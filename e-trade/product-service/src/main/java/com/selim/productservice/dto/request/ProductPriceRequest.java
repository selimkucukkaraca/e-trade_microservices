package com.selim.productservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceRequest {

    private String productId;
    private double newPrice;

}
