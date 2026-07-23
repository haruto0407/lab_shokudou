package com.example.cafeteria.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 食堂ユーザーテーブル ('cafeteria_users') に対応するJPAエンティティクラス。
 * データアクセス層（Data Access Layer）にてDB操作の対象となります。
 */
@Entity
@Table(name = "cafeteria_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_or_staff_id", nullable = false, unique = true, length = 20)
    private String studentOrStaffId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private UserRole role;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public UserEntity() {
    }

    public UserEntity(Long id, String studentOrStaffId, String name, String email, UserRole role, LocalDateTime createdAt) {
        this.id = id;
        this.studentOrStaffId = studentOrStaffId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentOrStaffId() {
        return studentOrStaffId;
    }

    public void setStudentOrStaffId(String studentOrStaffId) {
        this.studentOrStaffId = studentOrStaffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Custom Builder Pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String studentOrStaffId;
        private String name;
        private String email;
        private UserRole role;
        private LocalDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder studentOrStaffId(String studentOrStaffId) {
            this.studentOrStaffId = studentOrStaffId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder role(UserRole role) {
            this.role = role;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(id, studentOrStaffId, name, email, role, createdAt);
        }
    }
}
