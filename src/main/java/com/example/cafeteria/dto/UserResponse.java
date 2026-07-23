package com.example.cafeteria.dto;

import com.example.cafeteria.domain.UserEntity;

import java.time.LocalDateTime;

/**
 * ユーザー情報のレスポンス用DTO。
 * エンティティを直接外部へ露出させず、安全かつカプセル化された状態で返却します。
 */
public class UserResponse {

    private Long id;
    private String studentOrStaffId;
    private String name;
    private String email;
    private String roleLabel;
    private LocalDateTime createdAt;

    public UserResponse() {
    }

    public UserResponse(Long id, String studentOrStaffId, String name, String email, String roleLabel, LocalDateTime createdAt) {
        this.id = id;
        this.studentOrStaffId = studentOrStaffId;
        this.name = name;
        this.email = email;
        this.roleLabel = roleLabel;
        this.createdAt = createdAt;
    }

    public static UserResponse fromEntity(UserEntity entity) {
        return new UserResponse(
                entity.getId(),
                entity.getStudentOrStaffId(),
                entity.getName(),
                entity.getEmail(),
                entity.getRole() != null ? entity.getRole().getLabel() : "",
                entity.getCreatedAt()
        );
    }

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

    public String getRoleLabel() {
        return roleLabel;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
