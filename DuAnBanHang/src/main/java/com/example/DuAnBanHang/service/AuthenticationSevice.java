package com.example.DuAnBanHang.service;

import com.example.DuAnBanHang.dto.request.AuthenticationRequest;
import com.example.DuAnBanHang.dto.response.AuthenticationResponse;
import com.example.DuAnBanHang.entity.User;
import com.example.DuAnBanHang.exception.AppException;
import com.example.DuAnBanHang.exception.ErrException;
import com.example.DuAnBanHang.rerpositorys.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.StringJoiner;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationSevice {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    protected static final String KEY_SINGER = "ZNSMpt19M1W1J3plRQilQudB6AWMpZK6T6lcLJ4JjTtMBcKuUx";

    private String createToken(User user) {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUserName())
                .issuer("manhdz.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("scope", buildScopetoRole(user))
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        try {
            jwsObject.sign(new MACSigner(KEY_SINGER.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Can't create token" , e);
            throw new RuntimeException(e);
        }
    }
    public AuthenticationResponse authenticationResponse(AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByUserName(authenticationRequest.getUserName())
                .orElseThrow(() -> new AppException(ErrException.USER_EXISTED));
        boolean checker = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
        if (!checker) {
            throw new AppException(ErrException.PASSWORD_EXISTED);
        }
        var token = createToken(user);
        return  AuthenticationResponse.builder()
                .token(token)
                .check(true)
                .build();
    }
    public String buildScopetoRole(User user){
        StringJoiner stringJoiner = new StringJoiner(" ");
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            user.getRoles().forEach(stringJoiner::add);
        }
        return stringJoiner.toString();
    }
}
