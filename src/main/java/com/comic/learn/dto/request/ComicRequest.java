package com.comic.learn.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class ComicRequest {
  @NotBlank(message = "Không được để trống")
  private String title;

  @NotBlank(message = "Không được để trống")
  private String author;

  @DecimalMin(value = "0.0", inclusive = false)
  private Double price;

  @Min(value = 0, message = "Phải lớn hơn hoặc bằng 0")
  private Integer stock;
}
