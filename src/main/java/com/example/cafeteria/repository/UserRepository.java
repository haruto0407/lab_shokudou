package com.example.cafeteria.repository;

import com.example.cafeteria.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 食堂ユーザー情報のためのデータアクセスインターフェース（Data Access Layer）。
 * Spring Data JPAを利用し、一意性チェックや検索クエリを提供します。
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * 学籍番号/教職員番号によってユーザーを検索
     */
    @Query("SELECT u FROM UserEntity u WHERE u.studentOrStaffId = :id")
    Optional<UserEntity> findByStudentOrStaffId(@Param("id") String studentOrStaffId);

    /**
     * メールアドレスによってユーザーを検索
     */
    Optional<UserEntity> findByEmail(String email);

    /**
     * 指定された学籍番号/教職員番号が既に存在するか判定
     */
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.studentOrStaffId = :id")
    boolean existsByStudentOrStaffId(@Param("id") String studentOrStaffId);

    /**
     * 指定されたメールアドレスが既に存在するか判定
     */
    boolean existsByEmail(String email);
}
