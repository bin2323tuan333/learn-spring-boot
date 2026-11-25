package com.comic.learn.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse<T> {
  private Integer code;
  private String error;
  private String message;
  private T details;

  @Builder.Default
  private LocalDateTime timestamp = LocalDateTime.now();
}
