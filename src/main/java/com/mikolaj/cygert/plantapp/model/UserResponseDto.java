package com.mikolaj.cygert.plantapp.model;

import com.mikolaj.cygert.plantapp.entity.User;
import lombok.Value;

@Value
public class UserResponseDto {

    String userName;

    String email;

    String password;

    public UserResponseDto(User user) {
        userName = user.getUserName();
        email = user.getEmail();
        password = user.getPassword();
    }
}
