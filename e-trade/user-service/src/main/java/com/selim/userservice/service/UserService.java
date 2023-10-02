package com.selim.userservice.service;

import com.selim.core.exception.generic.GenericExistException;
import com.selim.entity.user.ConfirmCode;
import com.selim.entity.user.User;
import com.selim.shared.user.UserDto;
import com.selim.shared.user.converter.UserConverter;
import com.selim.shared.user.request.CreateUserRequest;
import com.selim.notificationservice.service.MailSendService;
import com.selim.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.selim.notificationservice.service.MailConstant.CONFIRM_CODE_DESCRIPTION;
import static com.selim.notificationservice.service.MailConstant.CONFIRM_CODE_TITLE;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @CachePut(value = "users", key = "#request")
    public UserDto save(CreateUserRequest request) {
        var saved = userConverter.toEntity(request);
        if (userRepository.existsUserByMail(saved.getMail())) {
            throw new GenericExistException("User already exist, mail: " + saved.getMail());
        }
        userRepository.save(saved);
        return userConverter.convertToDto(saved);
    }

    @CacheEvict(value = "users", key = "#mail")
    public void delete(String mail) {
        var fromUser = getUserByMail(mail);
        userRepository.delete(fromUser);
    }

    @Cacheable(value = "users", key = "#mail")
    public User getUserByMail(String mail) {
        return userRepository.findUserByMail(mail)
                .orElseThrow(() -> new GenericExistException("Mail not found: " + mail));
    }

    @Cacheable(value = "users", key = "#mail")
    public UserDto getByMail(String mail) {
        var fromDbUser = userRepository.findUserByMail(mail)
                .orElseThrow(() -> new GenericExistException("Mail not found: " + mail));
        return userConverter.convertToDto(fromDbUser);
    }

    public UserDto activeUser(String mail, int code) {
        var user = getUserByMail(mail);

        if (user.getConfirmCode().getCode() != code) {
            return null;
        }

        user.setActive(true);
        confirmCodeService.delete(user.getConfirmCode());
        userRepository.save(user);
        return userConverter.convertToDto(user);
    }

    public UserDto deActivateUser(String mail) {
        var fromDbUser = getUserByMail(mail);
        fromDbUser.setActive(false);
        userRepository.save(fromDbUser);
        return userConverter.convertToDto(fromDbUser);
    }

    public void sendConfirmCode(String mail) {
        var user = getUserByMail(mail);

        ConfirmCode confirmCode = new ConfirmCode();
        confirmCodeService.save(confirmCode);
        user.setConfirmCode(confirmCode);
        userRepository.save(user);

        String description = String.format(CONFIRM_CODE_DESCRIPTION, confirmCode.getCode());
        mailSendService.sendMail(user.getMail(), CONFIRM_CODE_TITLE, description);
    }
}
