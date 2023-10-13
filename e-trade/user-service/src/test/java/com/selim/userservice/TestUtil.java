package com.selim.userservice;

import com.selim.entity.user.*;
import com.selim.shared.user.AddressDto;
import com.selim.shared.user.SellerCommentDto;
import com.selim.shared.user.SellerDto;
import com.selim.shared.user.UserDto;
import com.selim.shared.user.request.CreateAddressRequest;
import com.selim.shared.user.request.CreateSellerCommentRequest;
import com.selim.shared.user.request.CreateSellerRequest;
import com.selim.shared.user.request.CreateUserRequest;

import java.util.List;

public abstract class TestUtil {

    public CreateUserRequest getCreateUserRequest() {
        return new CreateUserRequest("test", "test", "test", "test");
    }

    public List<UserDto> getUserDtoList() {
        return List.of(new UserDto("test", "test", "test", true));
    }

    public List<User> getUserList() {
        return List.of(new User(1L,"test", "test", "test", "test", true, null, List.of(new Address(
                "test",
                "test",
                "test",
                "test",
                "test"
        ))));
    }

    public CreateSellerRequest getCreateSellerRequest() {
        return new CreateSellerRequest("test", "test", "test", "test");
    }

    public List<SellerDto> getSellerDtoList() {
        return List.of(new SellerDto("test", "test", "test", true));
    }

    public List<Seller> getSellerList() {
        return List.of(new Seller(1L, "test", "test", "test", "test", true, null));
    }

    public CreateSellerCommentRequest getCreateSellerCommentRequest() {
        return new CreateSellerCommentRequest("test", "test", 1, "test", "test");
    }

    public List<SellerCommentDto> getSellerCommentDtoList() {
        return List.of(new SellerCommentDto("test", "test", 1, null, null));
    }

    public List<SellerComment> getSellerCommentList() {
        return List.of(new SellerComment(1L, "test", "test", 1, null, null, "test"));
    }

    public List<ConfirmCode> getConfirmCodeList() {
        return List.of(new ConfirmCode(1L, 0));
    }

    public CreateAddressRequest getCreateAddressRequest() {
        return new CreateAddressRequest("test", "test", "test", "test", "test");
    }

    public List<AddressDto> getAddressDtoList() {
        return List.of(new AddressDto("test", "test", "test", "test", "test"));
    }

    public List<Address> getAddressList() {
        return List.of(new Address("test", "test", "test", "test", "test"));
    }



}
