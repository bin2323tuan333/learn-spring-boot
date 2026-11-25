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
public class PaymentResponse {
  private Long id;
  private Long orderId;
  private String method;
  private Double amount;
  private String status;
  private LocalDateTime paidAt;
}
