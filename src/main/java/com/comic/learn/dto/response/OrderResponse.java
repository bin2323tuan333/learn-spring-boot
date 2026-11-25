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
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
  private Long id;
  private String customerName;
  private Long comicId;
  private Integer quantity;
  private Double totalPrice;
  private String status;
  private LocalDateTime createdAt;
}
