package com.comic.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.comic.learn.dto.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<Void>> handleValidation(MethodArgumentNotValidException ex) {
    ApiResponse<Void> response = ApiResponse.<Void>builder()
        .success(false)
        .code("VALIDATION_ERROR")
        .message("Dữ liệu đầu vào không hợp lệ")
        .build();
    return ResponseEntity
        .badRequest()
        .body(response);
  }

  @ExceptionHandler(AppException.class)
  public ResponseEntity<ApiResponse<Void>> handleAppException(AppException ex) {
    ApiResponse<Void> response = ApiResponse.<Void>builder()
        .success(false)
        .code(ex.getErrorCode().getCode())
        .message(ex.getErrorCode().getInformation())
        .build();
    return ResponseEntity
        .status(ex.getErrorCode().getStatusCode())
        .body(response);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<Void>> handleGeneric(Exception ex) {
    ApiResponse<Void> response = ApiResponse.<Void>builder()
        .success(false)
        .code("INTERNAL_ERROR")
        .message("Lỗi hệ thống")
        .build();
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(response);
  }
}