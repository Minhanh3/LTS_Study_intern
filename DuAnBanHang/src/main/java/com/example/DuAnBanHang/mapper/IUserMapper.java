package com.example.DuAnBanHang.mapper;


import com.example.DuAnBanHang.dto.request.UserCreateRequest;
import com.example.DuAnBanHang.dto.response.UserResponse;
import com.example.DuAnBanHang.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    User toUser(UserCreateRequest request);

    UserResponse toUserResponse(User user);

}
