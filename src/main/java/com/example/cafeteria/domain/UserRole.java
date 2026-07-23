package com.example.cafeteria.domain;

/**
 * 食堂ユーザーの区分を表す列挙型（Enum）
 */
public enum UserRole {
    STUDENT("学生"),
    FACULTY("教職員"),
    STAFF("食堂スタッフ");

    private final String label;

    UserRole(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
