package com.example.DuAnBanHang.service;

import com.example.DuAnBanHang.dto.UserDto;
import com.example.DuAnBanHang.dto.request.UserCreateRequest;
import com.example.DuAnBanHang.dto.request.UserUpdateRequest;
import com.example.DuAnBanHang.dto.response.UserResponse;

import java.util.List;

public interface IUserSevice  {

    UserResponse createUserApi(UserCreateRequest request);

    List<UserResponse> getAllUsersApi() ;

    UserResponse getUserByIdApi(int id);

    UserResponse updateUserApi(int id, UserUpdateRequest request);

    void deleteUser(int id);
}
