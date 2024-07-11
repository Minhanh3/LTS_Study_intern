package com.example.QuanLyBanHang.controller;

import com.example.QuanLyBanHang.entity.dto.UserDto;
import com.example.QuanLyBanHang.service.UserSevice;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserSevice userSevice;

    @PostMapping({"","/"})
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto newUser = userSevice.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
