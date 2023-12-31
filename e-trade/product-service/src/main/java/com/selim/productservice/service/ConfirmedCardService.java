package com.selim.productservice.service;

import com.selim.entity.product.ConfirmedCart;
import com.selim.productservice.repository.ConfirmedCartRepository;
import com.selim.shared.product.ConfirmedCartDto;
import com.selim.shared.product.converter.CartConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConfirmedCardService {

    private final ConfirmedCartRepository confirmedCartRepository;
    private final CartConverter cartConverter;

    @CachePut(value = "confirmedCards", key = "#confirmedCart")
    public ConfirmedCart save(ConfirmedCart confirmedCart) {
        log.info("cart info:" + confirmedCart);
        return confirmedCartRepository.save(confirmedCart);
    }

    @Cacheable(value = "confirmedCards", key = "#page and #size")
    public List<ConfirmedCartDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        System.out.println("custom log : " + confirmedCartRepository.findAll());
        return confirmedCartRepository.findAll(pageable)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ConfirmedCartDto toDto(ConfirmedCart confirmedCart) {
        return new ConfirmedCartDto(
                cartConverter.convertToDto(confirmedCart.getCarts()),
                confirmedCart.getConfirmedId()
        );
    }
}