package com.comic.learn.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
  @Builder.Default
  private boolean success = true;
  private String code;
  private String message;
  private T data;

  @Builder.Default
  private LocalDateTime timestamp = LocalDateTime.now();
}
