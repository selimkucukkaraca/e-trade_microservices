package com.selim.userservice.dto.converter;

import com.selim.userservice.dto.SellerDto;
import com.selim.userservice.dto.request.CreateSellerRequest;
import com.selim.userservice.model.Seller;
import org.springframework.stereotype.Component;

@Component
public class SellerConverter {

    public SellerDto convertToDto(Seller from) {
        return new SellerDto(
                from.getUsername(),
                from.getMail(),
                from.getImageUrl(),
                from.isActive()
        );
    }

    public Seller toEntity(CreateSellerRequest request) {
        return new Seller(
                request.getUsername(),
                request.getPassword(),
                request.getMail(),
                request.getImageUrl()
        );
    }
}