package com.example.QuanLyBanHang.rerpositorys;

import com.example.QuanLyBanHang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
