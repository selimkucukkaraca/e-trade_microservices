package com.selim.shared.product.converter;

import com.selim.entity.product.Cart;
import com.selim.shared.product.CartDto;
import com.selim.shared.product.ProductDto;
import com.selim.shared.user.converter.UserConverter;
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