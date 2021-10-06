package com.mikolaj.cygert.plantapp.service;

import com.mikolaj.cygert.plantapp.entity.User;
import com.mikolaj.cygert.plantapp.excepton.UserNotFoundException;
import com.mikolaj.cygert.plantapp.model.AuthorizeRequestDto;
import com.mikolaj.cygert.plantapp.model.UserResponseDto;
import com.mikolaj.cygert.plantapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserRepository userRepository;

    //Here we should use encrypted password with for example bcrypt
    //And if user is authorized with success we should give him JWT token populated with data instead of simple 200
    //Create better error handling
    public UserResponseDto authorizeUser(AuthorizeRequestDto authorizeRequestDto) {
        log.info("User with username: {} is trying to log in", authorizeRequestDto.getUserName());
        return userRepository.findByPasswordAndUserName(authorizeRequestDto.getPassword(), authorizeRequestDto.getUserName())
                .map(UserResponseDto::new)
                .orElseThrow(UserNotFoundException::new);

    }

    public User findUser(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(UserNotFoundException::new);
    }
}
