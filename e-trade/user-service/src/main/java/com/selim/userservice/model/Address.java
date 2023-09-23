package com.selim.userservice.model;

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
public class Address extends BaseEntity {

    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;
    private String addressId = UUID.randomUUID().toString();
}
