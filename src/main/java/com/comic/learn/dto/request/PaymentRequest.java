package com.comic.learn.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
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
public class PaymentRequest {
  @NotNull(message = "Không được để trống")
  private Long orderId;

  @NotNull
  private String method;

  @DecimalMin(value = "0.0", inclusive = false)
  private Double amount;
}
