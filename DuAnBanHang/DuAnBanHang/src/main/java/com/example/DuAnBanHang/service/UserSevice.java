package com.example.DuAnBanHang.service;

import com.example.DuAnBanHang.dto.request.UserCreateRequest;
import com.example.DuAnBanHang.dto.response.UserResponse;
import com.example.DuAnBanHang.entity.User;
import com.example.DuAnBanHang.dto.UserDto;
import com.example.DuAnBanHang.mapper.IUserMapper;
import com.example.DuAnBanHang.mapper.UserMapper;
import com.example.DuAnBanHang.rerpositorys.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserSevice implements IUserSevice {

    UserRepository userRepository;
    IUserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        user.setAvatar("avatar trắng");
        user.setCreateTime(LocalTime.now());
        user.setDateOfBirth(LocalDate.now());
        user.setActive(true);
        user.setUpdateTime(LocalTime.now());
        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }

    public UserResponse createUserApi(UserCreateRequest request) {
        User user = userMapper.toUser(request);
        user.setAvatar("avatar");
        user.setCreateTime(LocalTime.now());
        user.setDateOfBirth(LocalDate.now());
        user.setActive(true);
        user.setUpdateTime(LocalTime.now());
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        userRepository.findAll().forEach(user -> UserMapper.mapToUserDto(user));
        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }
    public List<UserResponse> getAllUsersApi() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist with given id: " + id));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist with given id: " + id));
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setAvatar(userDto.getAvatar());
        user.setEmail(userDto.getEmail());
        user.setUpdateTime(LocalTime.now());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setActive(userDto.isActive());
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist with given id: " + id));
        userRepository.deleteById(user.getId());
    }
}
