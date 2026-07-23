package com.example.cafeteria.dto;

import com.example.cafeteria.domain.UserRole;
import jakarta.validation.constraints.*;

/**
 * ユーザー登録リクエスト用DTO (Data Transfer Object)。
 * プレゼンテーション層にて入力受け取りとアノテーションバリデーション（Validation）を担います。
 */
public class UserRegisterRequest {

    @NotBlank(message = "学籍番号または教職員番号は必須です")
    @Pattern(regexp = "^[A-Za-z0-9]{5,20}$", message = "学籍番号/教職員番号は5〜20桁の半角英数字で入力してください")
    private String studentOrStaffId;

    @NotBlank(message = "氏名は必須です")
    @Size(max = 50, message = "氏名は50文字以内で入力してください")
    private String name;

    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "有効なメールアドレス形式で入力してください")
    private String email;

    @NotNull(message = "区分（学生/教職員/スタッフ）を選択してください")
    private UserRole role;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String studentOrStaffId, String name, String email, UserRole role) {
        this.studentOrStaffId = studentOrStaffId;
        this.name = name;
        this.email = email;
        this.role = role;
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

}
