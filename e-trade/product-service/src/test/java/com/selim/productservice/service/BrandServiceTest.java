package com.selim.productservice.service;

import com.selim.entity.product.Brand;
import com.selim.productservice.TestUtil;
import com.selim.productservice.repository.BrandRepository;
import com.selim.shared.product.BrandDto;
import com.selim.shared.product.converter.BrandConverter;
import com.selim.shared.product.request.CreateBrandRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class BrandServiceTest extends TestUtil {

    private BrandRepository brandRepository;
    private BrandConverter brandConverter;
    private BrandService brandService;

    @BeforeEach
    public void setUp() {
        brandRepository = mock(BrandRepository.class);
        brandConverter = mock(BrandConverter.class);
        brandService = new BrandService(brandRepository, brandConverter);
    }

    @Test
    public void saveBrand_itShouldReturnBrandDto() {

        CreateBrandRequest request = getCreateBrandRequest();
        Brand brand = getBrandList().get(0);
        BrandDto brandDto = getBrandDtoList().get(0);

        when(brandConverter.toEntity(request)).thenReturn(brand);
        when(brandRepository.save(brand)).thenReturn(brand);
        when(brandConverter.convertToDto(brand)).thenReturn(brandDto);

        BrandDto response = brandService.save(request);

        assertEquals(response, brandDto);

        verify(brandConverter).toEntity(request);
        verify(brandRepository).save(brand);
        verify(brandConverter).convertToDto(brand);

    }

    @Test
    public void delete() {

        Brand brand = getBrandList().get(0);
        String brandId = "test";

        when(brandRepository.findBrandByBrandId(brandId)).thenReturn(Optional.ofNullable(brand));

        brandService.deleteBrandByBrandId(brandId);

        assert brand != null;
        verify(brandRepository).delete(brand);

    }

    @Test
    public void getBrandByBrandId_itShouldReturnBrand() {

        Brand brand = getBrandList().get(0);
        String brandId = "test";

        when(brandRepository.findBrandByBrandId(brandId)).thenReturn(Optional.ofNullable(brand));

        Brand response = brandService.getBrandByBrandId(brandId);

        assertEquals(response, brand);
        verify(brandRepository).findBrandByBrandId(brandId);

    }

    @Test
    public void getBrandByBrand_itShouldReturnBrand() {

        Brand brand = getBrandList().get(0);

        when(brandRepository.findBrandByBrand("test")).thenReturn(brand);

        Brand response = brandService.getBrandByBrand("test");

        assertEquals(response, brand);
        verify(brandRepository).findBrandByBrand("test");

    }
}