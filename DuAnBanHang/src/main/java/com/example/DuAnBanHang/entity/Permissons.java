package com.example.DuAnBanHang.entity;

import jakarta.persistence.*;
import lombok.Data;

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
