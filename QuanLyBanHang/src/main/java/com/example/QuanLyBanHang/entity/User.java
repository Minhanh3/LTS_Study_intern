package com.example.QuanLyBanHang.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String password;
    private String fullName;
    private LocalTime dateOfBirth;
    private String avatar;

    @Column(unique = true, nullable = false)
    private String email;
    private LocalTime createTime;
    private LocalTime updateTime;
    private String phoneNumber;
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Permissons> permissonsList;
}
