package com.example.DuAnBanHang.service;

import com.example.DuAnBanHang.dto.UserDto;

import java.util.List;

public interface IUserSevice  {

    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(int id);

    UserDto updateUser(int id, UserDto userDto);

    void deleteUser(int id);
}
