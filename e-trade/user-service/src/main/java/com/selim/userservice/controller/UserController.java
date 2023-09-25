package com.selim.userservice.controller;

import com.selim.userservice.dto.UserDto;
import com.selim.userservice.dto.request.CreateUserRequest;
import com.selim.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody CreateUserRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String mail) {
        userService.delete(mail);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("/send-confirm-code")
    public ResponseEntity<?> sendConfirmCode(@RequestParam String mail) {
        userService.sendConfirmCode(mail);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{mail}")
    public ResponseEntity<UserDto> getByMail(@PathVariable String mail) {
        return ResponseEntity
                .ok(userService.getByMail(mail));
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

}