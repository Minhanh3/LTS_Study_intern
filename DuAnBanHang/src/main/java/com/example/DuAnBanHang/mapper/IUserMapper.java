package com.example.DuAnBanHang.mapper;


import com.example.DuAnBanHang.dto.request.UserCreateRequest;
import com.example.DuAnBanHang.dto.request.UserUpdateRequest;
import com.example.DuAnBanHang.dto.response.UserResponse;
import com.example.DuAnBanHang.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    User toUser(UserCreateRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
