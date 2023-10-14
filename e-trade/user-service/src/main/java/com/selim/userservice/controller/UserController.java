package com.selim.userservice.controller;

import com.selim.entity.user.User;
import com.selim.shared.user.UserDto;
import com.selim.shared.user.request.CreateUserRequest;
import com.selim.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody CreateUserRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String mail) {
        userService.delete(mail);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("/send-confirm-code")
    public ResponseEntity<Void> sendConfirmCode(@RequestParam String mail) {
        userService.sendConfirmCode(mail);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{mail}")
    public ResponseEntity<User> getByMail(@PathVariable String mail) {
        return ResponseEntity
                .ok(userService.getUserByMail(mail));
    }

    @PatchMapping("/active-user")
    public ResponseEntity<UserDto> activateUser(@RequestParam String mail, @RequestParam int code) {
        return ResponseEntity
                .ok(userService.activeUser(mail, code));
    }

    @PatchMapping("/deActive-user")
    public ResponseEntity<UserDto> deActiveUser(@RequestParam String mail) {
        return ResponseEntity
                .ok(userService.deActivateUser(mail));
    }

    @GetMapping("/mail")
    public ResponseEntity<UserDto> getUserByMail(@RequestParam String mail) {
        return ResponseEntity
                .ok(userService.getByMail(mail));
    }

}
