package com.selim.userservice.service;

import com.selim.core.exception.NotFoundException;
import com.selim.entity.user.Address;
import com.selim.shared.user.AddressDto;
import com.selim.shared.user.converter.AddressConverter;
import com.selim.shared.user.request.CreateAddressRequest;
import com.selim.userservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final UserService userService;

    public Address save(CreateAddressRequest request) {
        var saved = addressConverter.toEntity(request);
        return addressRepository.save(saved);
    }

    public void delete(String addressId) {
        var fromAddress = getAddress(addressId);
        addressRepository.delete(fromAddress);
    }

    public AddressDto getAddressByAddressId(String addressId) {
        var address = addressRepository.findAddressByAddressId(addressId)
                .orElseThrow(() -> new NotFoundException(""));
        return addressConverter.convertToDto(address);
    }

    public List<AddressDto> getAddressListByUserMail(String mail) {
        var fromUser = userService.getUserByMail(mail);
        return fromUser.getAddress()
                .stream()
                .map(addressConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public Address getAddress(String addressId) {
        return addressRepository.getAddressByAddressId(addressId)
                .orElseThrow(() -> new RuntimeException(""));
    }
}