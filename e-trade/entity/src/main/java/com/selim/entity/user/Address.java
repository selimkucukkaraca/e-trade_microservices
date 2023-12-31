package com.selim.entity.user;

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
public class Address extends BaseEntity {

    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;
    private String addressId = UUID.randomUUID().toString();

    public Address(String city, String district, String street,
                   String apartmentNumber, String phoneNumber) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.phoneNumber = phoneNumber;
    }
}
