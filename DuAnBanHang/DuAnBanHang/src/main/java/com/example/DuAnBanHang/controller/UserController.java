package com.example.DuAnBanHang.controller;

import com.example.DuAnBanHang.dto.UserDto;
import com.example.DuAnBanHang.dto.request.UserCreateRequest;
import com.example.DuAnBanHang.dto.response.ApiResponse;
import com.example.DuAnBanHang.dto.response.UserResponse;
import com.example.DuAnBanHang.service.UserSevice;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserSevice userSevice;

    @GetMapping({"", "/"})
    public ApiResponse<List<UserResponse>> getAll() {
//        List<UserDto> users = userSevice.getAllUsers();
        return ApiResponse.<List<UserResponse>>builder()
                .result(userSevice.getAllUsersApi())
                .code(200)
                .build();
    }

    @PostMapping({"addUser", "/"})
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
//        UserDto newUser = userSevice.createUser(userDto);
        return ApiResponse.<UserResponse>builder()
                .result(userSevice.createUserApi(request))
                .code(200)
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        UserDto userDto = userSevice.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userSevice.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userSevice.deleteUser(id);
        return ResponseEntity.ok("Deleted User");
    }

}
