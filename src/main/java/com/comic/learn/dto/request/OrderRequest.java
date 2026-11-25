package com.comic.learn.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class OrderRequest {
  @NotBlank(message = "Không được để trống")
  private String customerName;

  @NotNull(message = "Không được để trống")
  private Long comicId;

  @Min(value = 1, message = "Phải lớn hơn 0")
  private Integer quantity;
}
