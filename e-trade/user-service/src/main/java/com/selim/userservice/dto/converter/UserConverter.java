package com.selim.userservice.dto.converter;

import com.selim.userservice.dto.UserDto;
import com.selim.userservice.dto.request.CreateUserRequest;
import com.selim.userservice.model.User;
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