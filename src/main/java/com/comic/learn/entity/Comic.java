package com.comic.learn.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comics")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String author;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private Integer stock;

  @Column(updatable = false)
  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();
}
