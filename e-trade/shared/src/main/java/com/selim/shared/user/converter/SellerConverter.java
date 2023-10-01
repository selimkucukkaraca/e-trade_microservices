package com.selim.shared.user.converter;

import com.selim.entity.user.Seller;
import com.selim.shared.user.SellerDto;
import com.selim.shared.user.request.CreateSellerRequest;
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