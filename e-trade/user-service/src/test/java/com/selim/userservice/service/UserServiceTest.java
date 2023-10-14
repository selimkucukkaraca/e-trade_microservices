package com.selim.userservice.service;

import com.selim.entity.user.User;
import com.selim.notificationservice.service.MailSendService;
import com.selim.shared.user.UserDto;
import com.selim.shared.user.converter.UserConverter;
import com.selim.shared.user.request.CreateUserRequest;
import com.selim.userservice.TestUtil;
import com.selim.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class UserServiceTest extends TestUtil {

    private MailSendService mailSendService;
    private ConfirmCodeService confirmCodeService;
    private UserConverter userConverter;
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        mailSendService = mock(MailSendService.class);
        confirmCodeService = mock(ConfirmCodeService.class);
        userConverter = mock(UserConverter.class);
        userRepository = mock(UserRepository.class);
        userService = new UserService(mailSendService, confirmCodeService, userConverter, userRepository);
    }

    @Test
    public void saveUser_itShouldReturnUserDto() {

        CreateUserRequest request = getCreateUserRequest();
        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);

        when(userConverter.toEntity(request)).thenReturn(user);
        when(userRepository.existsByMail("test")).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);
        when(userConverter.convertToDto(user)).thenReturn(userDto);

        UserDto response = userService.save(request);

        assertEquals(response, userDto);
        verify(userConverter).toEntity(request);
        verify(userRepository).existsByMail("test");
        verify(userRepository).save(user);
        verify(userConverter).convertToDto(user);

    }

    @Test
    public void delete() {

        User user = getUserList().get(0);
        String mail = "test";

        when(userRepository.findByMail(mail)).thenReturn(Optional.ofNullable(user));

        userService.delete(mail);

        assert user != null;
        verify(userRepository).delete(user);

    }

    @Test
    public void getByMail_itShouldReturnUserDto() {

        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);
        String mail = "test";

        when(userRepository.findByMail(mail)).thenReturn(Optional.ofNullable(user));
        assert user != null;
        when(userConverter.convertToDto(user)).thenReturn(userDto);

        UserDto response = userService.getByMail(mail);

        assertEquals(response, userDto);
        verify(userRepository).findByMail(mail);
        verify(userConverter).convertToDto(user);

    }

    @Test
    public void getUserByMail_itShouldReturnUser() {

        User user = getUserList().get(0);
        String mail = "test";

        when(userRepository.findByMail(mail)).thenReturn(Optional.ofNullable(user));

        User response = userService.getUserByMail(mail);

        assertEquals(response, user);
        verify(userRepository).findByMail(mail);

    }

    @Test
    public void deActiveUser_itShouldReturnUserDto() {
        User user = getUserList().get(0);
        UserDto userDto = getUserDtoList().get(0);

        when(userRepository.save(user)).thenReturn(user);
        when(userConverter.convertToDto(user)).thenReturn(userDto);
        when(userRepository.findByMail("test")).thenReturn(Optional.of(user));

        UserDto response = userService.deActivateUser("test");

        assertEquals(userDto, response);
        verify(userRepository).save(user);
        verify(userConverter).convertToDto(user);
        verify(userRepository).findByMail("test");

    }

}