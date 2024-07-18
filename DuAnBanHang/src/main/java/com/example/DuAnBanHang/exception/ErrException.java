package com.example.DuAnBanHang.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrException {

    USER_EXISTED(101 , "User exitsed"),
    PASSWORD_EXISTED(101 , "PASSWORD exitsed"),
    USER_NO_EXISTED(102 ,"User NOT EXISTED") ,
    USER_ALREADY_EXISTED(103 , "User already existed"),
    INVALID_USERNAME(103 , "Invalid username"),
    INVALID_PASSWORD(103 , "PASSWORD MUST BE AT 4 CHARACTER"),
    INVALID_KEY(105 , "Invalid key"),
        ERR_EXCEPTION(99 , "ERR EXCEPTION")
    ;
    private int code ;

    private String message ;
}
