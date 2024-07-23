package com.example.DuAnBanHang.rerpositorys;

import com.example.DuAnBanHang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findByEmail(String email);

    boolean existsByUserName(String username);

    Optional<User> findByUserName(String username);

    //JPQL
    @Query("SELECT u FROM User u WHERE u.fullName=:fullName")
    List<User> findByFullName(@Param("fullName") String fullName);

    //Native query
    @Query(value = """
                    SELECT * FROM user WHERE full_name=:fullName 
            """, nativeQuery = true)
    List<User> findByFullNameQuery(@Param("fullName") String fullName);
}
