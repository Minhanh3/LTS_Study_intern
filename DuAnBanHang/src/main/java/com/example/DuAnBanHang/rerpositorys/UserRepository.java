package com.example.DuAnBanHang.rerpositorys;

import com.example.DuAnBanHang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    boolean existsByUserName(String username);

    Optional<User> findByUserName(String username);
}
