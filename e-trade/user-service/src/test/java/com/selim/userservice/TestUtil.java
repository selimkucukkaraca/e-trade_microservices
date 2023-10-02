package com.selim.userservice;

import com.selim.entity.user.Address;
import com.selim.entity.user.User;
import com.selim.shared.user.UserDto;
import com.selim.shared.user.request.CreateUserRequest;

import java.util.List;

public class TestUtil {

    public CreateUserRequest getCreateUserRequest() {
        return new CreateUserRequest("test", "test", "test", "test");
    }

    public List<UserDto> getUserDtoList() {
        return List.of(new UserDto("test", "test", "test", true));
    }

    //todo new User'da 1l, olmasi lazim
    public List<User> getUserList() {
        return List.of(new User("test", "test", "test", "test", true, null, List.of(new Address(
                "test",
                "test",
                "test",
                "test",
                "test"
        ))));
    }
}
