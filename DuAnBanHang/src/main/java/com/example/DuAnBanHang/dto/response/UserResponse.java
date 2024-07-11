package com.example.DuAnBanHang.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    int id;
    String userName;
    String password;
    String fullName;
    LocalDate dateOfBirth;
    String avatar;

    String email;
    LocalTime createTime;
    LocalTime updateTime;
    String phoneNumber;
    boolean isActive;
}
