package com.example.DuAnBanHang.config;

import com.example.DuAnBanHang.entity.Roles;
import com.example.DuAnBanHang.entity.User;
import com.example.DuAnBanHang.rerpositorys.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateAdminConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        log.warn("no admin");
        return args -> {
            if (userRepository.findByUserName("admin").isEmpty()) {
                var roles = new HashSet<String>();
                roles.add(Roles.Admin.name());
                User user = User.builder()
                        .userName("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles(roles)
                        .build();
                userRepository.save(user);
                log.warn("is admin");
            }
        };
    }
}
