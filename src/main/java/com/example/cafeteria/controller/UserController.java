package com.example.cafeteria.controller;

import com.example.cafeteria.dto.UserRegisterRequest;
import com.example.cafeteria.dto.UserResponse;
import com.example.cafeteria.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ユーザー関連のHTTPリクエストを受け付けるRESTコントローラー（Presentation Layer）。
 * リクエストの検証発火（@Valid）とレスポンスステータス制御に特化し、ビジネスロジックはServiceへ委譲します。
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 食堂ユーザーの新規登録エンドポイント
     *
     * @param request ユーザー登録リクエスト (自動バリデーション対象)
     * @return 登録されたユーザー情報 (201 Created)
     */
    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegisterRequest request) {
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * 登録済みユーザー一覧取得エンドポイント
     *
     * @return ユーザー一覧リスト (200 OK)
     */
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
