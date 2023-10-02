package com.selim.userservice.service;

import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.user.Address;
import com.selim.shared.user.AddressDto;
import com.selim.shared.user.converter.AddressConverter;
import com.selim.shared.user.request.CreateAddressRequest;
import com.selim.userservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final UserService userService;

    @CachePut(value = "addresses", key = "#request")
    public Address save(CreateAddressRequest request) {
        var saved = addressConverter.toEntity(request);
        return addressRepository.save(saved);
    }

    @CacheEvict(value = "addresses", key = "#addressId")
    public void delete(String addressId) {
        var fromAddress = getAddress(addressId);
        addressRepository.delete(fromAddress);
    }

    @Cacheable(value = "addresses", key = "#addressId")
    public AddressDto getAddressByAddressId(String addressId) {
        var address = addressRepository.findAddressByAddressId(addressId)
                .orElseThrow(() -> new GenericExistException("Address not found: " + addressId));
        return addressConverter.convertToDto(address);
    }

    @Cacheable(value = "addresses", key = "#mail")
    public List<AddressDto> getAddressListByUserMail(String mail) {
        var fromUser = userService.getUserByMail(mail);
        return fromUser.getAddress()
                .stream()
                .map(addressConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "addresses", key = "#addressId")
    public Address getAddress(String addressId) {
        return addressRepository.getAddressByAddressId(addressId)
                .orElseThrow(() -> new GenericExistException("Address not found: " + addressId));
    }
}