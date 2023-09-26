package com.selim.productservice.model;

import com.selim.core.entity.BaseEntity;
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

    public Brand(String brand) {
        this.brand = brand;
    }
}