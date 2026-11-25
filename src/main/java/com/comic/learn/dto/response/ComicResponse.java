package com.comic.learn.dto.response;

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
public class ComicResponse {
  private Long id;
  private String title;
  private String author;
  private Double price;
  private Integer stock;
}
