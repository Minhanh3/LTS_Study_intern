package com.example.DuAnBanHang.controller;


import com.example.DuAnBanHang.dto.request.AuthenticationRequest;
import com.example.DuAnBanHang.dto.response.ApiResponse;
import com.example.DuAnBanHang.dto.response.AuthenticationResponse;
import com.example.DuAnBanHang.service.AuthenticationSevice;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationSevice authenticationSevice;

    @PostMapping({"token"})
    public ApiResponse<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest) {
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authenticationSevice.authenticationResponse(authenticationRequest))
                .code(200)
                .build();
    }
}
