package com.selim.productservice.dto.converter;

import com.selim.productservice.dto.CartDto;
import com.selim.productservice.dto.ProductDto;
import com.selim.productservice.model.Cart;
import com.selim.userservice.dto.converter.UserConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartConverter {

    private final ProductConverter productConverter;
    private final UserConverter userConverter;

    public CartConverter(ProductConverter productConverter, UserConverter userConverter) {
        this.productConverter = productConverter;
        this.userConverter = userConverter;
    }

    public CartDto convertToDto(Cart from) {
        List<ProductDto> productDto = from.getProduct()
                .stream()
                .map(productConverter::convertToDto).collect(Collectors.toList());

        return new CartDto(
                productDto,
                userConverter.convertToDto(from.getUser())
        );
    }
}