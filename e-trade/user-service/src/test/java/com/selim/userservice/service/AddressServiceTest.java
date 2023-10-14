package com.selim.userservice.service;

import com.selim.entity.user.Address;
import com.selim.shared.user.AddressDto;
import com.selim.shared.user.converter.AddressConverter;
import com.selim.shared.user.request.CreateAddressRequest;
import com.selim.userservice.TestUtil;
import com.selim.userservice.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class AddressServiceTest extends TestUtil {

    private AddressRepository addressRepository;
    private AddressConverter addressConverter;
    private UserService userService;
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        addressRepository = mock(AddressRepository.class);
        addressConverter = mock(AddressConverter.class);
        userService = mock(UserService.class);
        addressService = new AddressService(addressRepository, addressConverter, userService);
    }

    @Test
    void saveAddress_itShouldReturnAddressDto() {

        CreateAddressRequest request = getCreateAddressRequest();
        Address address = getAddressList().get(0);

        when(addressConverter.toEntity(request)).thenReturn(address);
        when(addressRepository.save(address)).thenReturn(address);

        Address response = addressService.save(request);

        assertEquals(response, address);
        verify(addressConverter).toEntity(request);
        verify(addressRepository).save(address);
    }

    @Test
    void delete() {

        String addressId = "test";
        Address address = getAddressList().get(0);

        when(addressRepository.getByAddressId(addressId)).thenReturn(Optional.ofNullable(address));

        addressService.delete(addressId);

    }

    @Test
    void getAddressByAddressId_itShouldReturnAddressDto() {

        Address address = getAddressList().get(0);
        AddressDto addressDto = getAddressDtoList().get(0);
        String addressId = "test";

        when(addressRepository.findByAddressId(addressId)).thenReturn(Optional.ofNullable(address));
        assert address != null;
        when(addressConverter.convertToDto(address)).thenReturn(addressDto);

        AddressDto response = addressService.getAddressByAddressId(addressId);

        assertEquals(response, addressDto);
        verify(addressRepository).findByAddressId(addressId);
        verify(addressConverter).convertToDto(address);

    }

    @Test
    void getAddress_itShouldReturnAddress() {

        Address address = getAddressList().get(0);
        String addressId = "test";

        when(addressRepository.getByAddressId(addressId)).thenReturn(Optional.ofNullable(address));

        Address response = addressService.getAddress(addressId);

        assertEquals(response, address);
        verify(addressRepository).getByAddressId(addressId);

    }

    @Test
    void getAddressListByUserMail_itShouldReturnAddressDto(){
       //TODO
    }
}