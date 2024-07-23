package com.example.DuAnBanHang.service;

import com.example.DuAnBanHang.dto.request.UserCreateRequest;
import com.example.DuAnBanHang.dto.request.UserUpdateRequest;
import com.example.DuAnBanHang.dto.response.UserResponse;
import com.example.DuAnBanHang.entity.Roles;
import com.example.DuAnBanHang.entity.User;
import com.example.DuAnBanHang.dto.UserDto;
import com.example.DuAnBanHang.exception.AppException;
import com.example.DuAnBanHang.exception.ErrException;
import com.example.DuAnBanHang.mapper.IUserMapper;
import com.example.DuAnBanHang.mapper.UserMapper;
import com.example.DuAnBanHang.rerpositorys.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserSevice implements IUserSevice {

    UserRepository userRepository;
    IUserMapper userMapper;
    ModelMapper modelMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUserApi(UserCreateRequest request) {
        if (userRepository.existsByUserName(request.getUserName())) {
            throw new AppException(ErrException.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setAvatar("avatar");
        user.setCreateTime(LocalTime.now());
        user.setDateOfBirth(LocalDate.now());
        user.setActive(true);
        user.setUpdateTime(LocalTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Roles.User.name());
        user.setRoles(roles);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }

    @PreAuthorize("hasRole('Admin')")
    @Override
    public List<UserResponse> getAllUsersApi() {
        log.info("getAllUsersApi is admin");
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    //get user
    @PostAuthorize("returnObject.userName ==authentication.name or hasRole('ROLE_Admin')")
    @Override
    public UserResponse getUserByIdApi(int id) {
        log.info("getUserByIdApi is admin or user yes");
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrException.USER_NO_EXISTED)));

    }

    public UserDto getUserByIdModel(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserDto userDto = modelMapper.map(user.get(), UserDto.class);
            return userDto;
        }
        return null;
    }

    public UserResponse getUserByIdApiModel(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserResponse userResponse = modelMapper.map(user.get(), UserResponse.class);
            return userResponse;
        }
        return null;
    }

    //end get
    @Override
    public UserResponse updateUserApi(int id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist with given id: " + id));
        user.setUpdateTime(LocalTime.now());
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User is not exist with given id: " + id));
        userRepository.deleteById(id);
    }

    public List<UserResponse> getUsersByFullName(String fullName) {
        List<User> users = userRepository.findByFullNameQuery(fullName);
        return users.stream()
                .map(userMapper::toUserResponse)
                .toList();
    }
}
