package com.example.DuAnBanHang.rerpositorys;

import com.example.DuAnBanHang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
