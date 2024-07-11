package com.example.DuAnBanHang.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String userName;
    private String password;
    private String fullName;
    private LocalDate dateOfBirth;
    private String avatar;
    private String email;
    private LocalTime createTime;
    private LocalTime updateTime;
    private String phoneNumber;
    private boolean isActive;
}
