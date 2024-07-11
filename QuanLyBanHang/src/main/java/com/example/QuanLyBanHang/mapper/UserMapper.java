package com.example.QuanLyBanHang.mapper;

import com.example.QuanLyBanHang.entity.User;
import com.example.QuanLyBanHang.entity.dto.UserDto;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getFullName(),
                user.getDateOfBirth(),
                user.getAvatar(),
                user.getEmail(),
                user.getCreateTime(),
                user.getUpdateTime(),
                user.getPhoneNumber(),
                user.isActive()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getFullName(),
                userDto.getDateOfBirth(),
                userDto.getAvatar(),
                userDto.getEmail(),
                userDto.getCreateTime(),
                userDto.getUpdateTime(),
                userDto.getPhoneNumber(),
                userDto.isActive(),
                null
        );
    }
}
