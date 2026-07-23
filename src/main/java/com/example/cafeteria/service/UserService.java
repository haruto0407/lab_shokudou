package com.example.cafeteria.service;

import com.example.cafeteria.dto.UserRegisterRequest;
import com.example.cafeteria.dto.UserResponse;

import java.util.List;

/**
 * ユーザー登録処理の業務ロジックを規定するサービスインターフェース（Business Logic Layer）。
 */
public interface UserService {

    /**
     * 食堂ユーザーを新規登録する
     *
     * @param request 登録リクエストDTO
     * @return 登録完了後のユーザーレスポンスDTO
     */
    UserResponse registerUser(UserRegisterRequest request);

    /**
     * 登録済みの全ユーザー一覧を取得する
     *
     * @return ユーザーレスポンスDTOリスト
     */
    List<UserResponse> getAllUsers();
}
