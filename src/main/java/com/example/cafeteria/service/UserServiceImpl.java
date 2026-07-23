package com.example.cafeteria.service;

import com.example.cafeteria.domain.UserEntity;
import com.example.cafeteria.dto.UserRegisterRequest;
import com.example.cafeteria.dto.UserResponse;
import com.example.cafeteria.exception.UserAlreadyExistsException;
import com.example.cafeteria.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 食堂ユーザー管理サービスの実装クラス（Business Logic Layer）。
 * 業務ルールの適用、一意性制約の事前チェック、エンティティの組み立ておよびトランザクション制御を担います。
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserResponse registerUser(UserRegisterRequest request) {
        // 1. 学籍番号/教職員番号の重複チェック
        if (userRepository.existsByStudentOrStaffId(request.getStudentOrStaffId())) {
            throw new UserAlreadyExistsException(
                    "指定された学籍番号/教職員番号 [" + request.getStudentOrStaffId() + "] は既に登録されています。"
            );
        }

        // 2. メールアドレスの重複チェック
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(
                    "指定されたメールアドレス [" + request.getEmail() + "] は既に登録されています。"
            );
        }

        // 3. 業務ルール適用 & エンティティ構築
        UserEntity newUser = UserEntity.builder()
                .studentOrStaffId(request.getStudentOrStaffId())
                .name(request.getName())
                .email(request.getEmail())
                .role(request.getRole())
                .build();

        // 4. データアクセス層（Repository）を介してDBに保存
        UserEntity savedUser = userRepository.save(newUser);

        // 5. エンティティを安全なレスポンスDTOに変換して返却
        return UserResponse.fromEntity(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
