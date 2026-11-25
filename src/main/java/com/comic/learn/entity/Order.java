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
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String customerName;

  @Column(nullable = false)
  private Integer quantity;

  @Column(nullable = false)
  private Double totalPrice;

  @Column(nullable = false)
  @Builder.Default
  private String status = "PENDING";

  @Column(nullable = false)
  private Long comicId;

  @Column(updatable = false)
  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();
}
