package com.mikolaj.cygert.plantapp.controller;

import com.mikolaj.cygert.plantapp.model.AuthorizeRequestDto;
import com.mikolaj.cygert.plantapp.model.UserResponseDto;
import com.mikolaj.cygert.plantapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserService userService;

    @PostMapping("/user")
    public UserResponseDto authorizeUser(@Valid AuthorizeRequestDto authorizeRequestDto) {
        return userService.authorizeUser(authorizeRequestDto);
    }

}
