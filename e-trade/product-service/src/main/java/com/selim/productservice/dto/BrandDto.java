package com.selim.productservice.dto;

import com.selim.core.dto.BaseDto;
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
