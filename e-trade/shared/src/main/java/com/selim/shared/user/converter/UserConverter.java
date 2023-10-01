package com.selim.shared.user.converter;

import com.selim.entity.user.User;
import com.selim.shared.user.UserDto;
import com.selim.shared.user.request.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto convertToDto(User from) {
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                from.getImageUrl(),
                from.isActive()
        );
    }

    public User toEntity(CreateUserRequest request) {
        return new User(
                request.getUsername(),
                request.getPassword(),
                request.getMail(),
                request.getImageUrl()
        );
    }
}