package com.selim.shared.product;

import com.selim.shared.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BrandDto extends BaseDto {

    private String brand;
    private String brandId;

}
