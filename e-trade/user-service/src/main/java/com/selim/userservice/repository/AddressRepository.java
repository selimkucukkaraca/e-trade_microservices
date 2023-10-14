package com.selim.userservice.repository;

import com.selim.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByAddressId(String addressId);
    Optional<Address> getByAddressId(String id);
}