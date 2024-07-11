package com.example.QuanLyBanHang.service;

import com.example.QuanLyBanHang.entity.User;
import com.example.QuanLyBanHang.entity.dto.UserDto;
import com.example.QuanLyBanHang.mapper.UserMapper;
import com.example.QuanLyBanHang.rerpositorys.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserSevice implements IUserSevice {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        user.setAvatar("avatar trắng");
        user.setCreateTime(LocalTime.now());
        user.setDateOfBirth(LocalTime.now());
        user.setActive(true);
        user.setUpdateTime(LocalTime.now());
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto getUserById(int id) {
        return null;
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
