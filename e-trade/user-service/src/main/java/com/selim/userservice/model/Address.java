package com.selim.userservice.model;

import com.selim.core.entity.BaseEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
