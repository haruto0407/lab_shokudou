package com.example.cafeteria.exception;

/**
 * 登録対象の学籍番号/教職員番号、またはメールアドレスが既に登録済みの場合にスローされるビジネス例外
 */
public class UserAlreadyExistsException extends RuntimeException {
    
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
