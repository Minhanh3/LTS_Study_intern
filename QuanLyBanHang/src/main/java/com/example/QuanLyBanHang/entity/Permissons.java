package com.example.QuanLyBanHang.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "permissons")
@Data
public class Permissons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
    private User user;

    private int roleId;
    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false, insertable = false, updatable = false)
    private Role role;
}
