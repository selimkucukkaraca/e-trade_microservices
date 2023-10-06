package com.selim.entity.product;

import com.selim.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand extends BaseEntity {

    private String brand;
    private String brandId = UUID.randomUUID().toString();

    public Brand(Long id,String brand, String brandId) {
        super.setId(id);
        this.brand = brand;
        this.brandId = brandId;
    }

    public Brand(String brand) {
        this.brand = brand;
    }

}