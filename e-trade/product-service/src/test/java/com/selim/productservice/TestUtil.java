package com.selim.productservice;

import com.selim.entity.product.*;
import com.selim.shared.product.BrandDto;
import com.selim.shared.product.ProductCommentDto;
import com.selim.shared.product.ProductDto;
import com.selim.shared.product.request.CreateBrandRequest;
import com.selim.shared.product.request.CreateProductCommentRequest;
import com.selim.shared.product.request.CreateProductRequest;

import java.util.List;

public class TestUtil {

    public List<BankAccount> getBankAccountList() {
        return List.of(new BankAccount(1L, "test", "test", 0, "test", 1L));
    }

    public CreateBrandRequest getCreateBrandRequest() {
        CreateBrandRequest request = new CreateBrandRequest();
        request.setBrand("test");
        return request;
    }

    public List<BrandDto> getBrandDtoList() {
        return List.of(new BrandDto("test", "test"));
    }

    public List<Brand> getBrandList() {
        return List.of(new Brand(1L, "test", "test"));
    }

    public List<ConfirmedCart> getConfirmedCartList() {
        return List.of(new ConfirmedCart(null, null));
    }

    public CreateProductCommentRequest getCreateProductCommentRequest() {
        return new CreateProductCommentRequest("test", "test", 0, "test", "test");
    }

    public List<ProductCommentDto> getProductCommentDtoList() {
        return List.of(new ProductCommentDto("test", "test", 0, null, null));
    }

    public List<ProductComment> getProductCommentList() {
        return List.of(new ProductComment(1L, "test", "test", 0, null, "test", null));
    }

    public CreateProductRequest getCreateProductRequest() {
        return new CreateProductRequest("test", "test", 1L, 0, "test", "test", "test");
    }

    public List<ProductDto> getProductDtoList() {
        return List.of(new ProductDto("test", "test", 1L, 0, "test", "test", null));
    }

    public List<Product> getProductList() {
        return List.of(new Product(1L, "test", "test", 1L, 0, "test", null, null, "test", null));
    }

}
