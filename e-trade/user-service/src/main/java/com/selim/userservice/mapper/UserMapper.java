package com.selim.userservice.mapper;

import com.selim.userservice.dto.UserDto;
import com.selim.userservice.dto.request.CreateUserRequest;
import com.selim.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
    User toEntity(CreateUserRequest request);
}
