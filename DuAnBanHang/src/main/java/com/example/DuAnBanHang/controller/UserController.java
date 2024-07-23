package com.example.DuAnBanHang.controller;

import com.example.DuAnBanHang.dto.UserDto;
import com.example.DuAnBanHang.dto.request.UserCreateRequest;
import com.example.DuAnBanHang.dto.request.UserUpdateRequest;
import com.example.DuAnBanHang.dto.response.ApiResponse;
import com.example.DuAnBanHang.dto.response.UserResponse;
import com.example.DuAnBanHang.service.UserSevice;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("*")
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserSevice userSevice;

    @GetMapping({"", "/"})
    public ApiResponse<List<UserResponse>> getAll() {
//        System.out.printf("hello");
        return ApiResponse.<List<UserResponse>>builder()
                .code(200)
                .result(userSevice.getAllUsersApi())
                .build();
    }

    @PostMapping({"addUser", ""})
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
//        UserDto newUser = userSevice.createUser(userDto);
        return ApiResponse.<UserResponse>builder()
                .result(userSevice.createUserApi(request))
                .code(200)
                .build();
    }

    @GetMapping("{id}")
    public ApiResponse<UserResponse> getUserByid(@PathVariable int id) {
        return ApiResponse.<UserResponse>builder()
                .result(userSevice.getUserByIdApi(id))
                .code(200)
                .build();
    }

    @GetMapping("model/{id}")
    public ApiResponse<UserResponse> getUserByidModel(@PathVariable int id) {
        return ApiResponse.<UserResponse>builder()
                .result(userSevice.getUserByIdApiModel(id))
                .code(200)
                .build();
    }

    @GetMapping("model2/{id}")
    public ResponseEntity<UserDto> getUserByidModel2(@PathVariable int id) {
        UserDto userDto = userSevice.getUserByIdModel(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable int id, @RequestBody UserUpdateRequest request) {
//        UserDto updatedUser = userSevice.updateUser(id, userDto);
        return ApiResponse.<UserResponse>builder()
                .result(userSevice.updateUserApi(id, request))
                .code(200)
                .build();
    }

    @DeleteMapping("{id}")
    public ApiResponse<String> deleteUser(@PathVariable int id) {
        userSevice.deleteUser(id);
        return ApiResponse.<String>builder()
                .result("delete oke")
                .code(200)
                .build();
    }

    @GetMapping("/users")
    public ApiResponse<List<UserResponse>> getUsersByFullName(@RequestParam String fullName) {
        return ApiResponse.<List<UserResponse>>builder()
                .result(userSevice.getUsersByFullName(fullName))
                .build();
    }
}
