package com.comic.learn.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comic.learn.dto.request.OrderRequest;
import com.comic.learn.dto.response.ApiResponse;
import com.comic.learn.dto.response.OrderResponse;
import com.comic.learn.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @GetMapping
  public ApiResponse<List<OrderResponse>> getAllOrders() {
    return ApiResponse.<List<OrderResponse>>builder()
        .data(orderService.getAllOrders())
        .build();
  }

  @GetMapping("/{id}")
  public ApiResponse<OrderResponse> getOrder(@PathVariable Long id) {
    return ApiResponse.<OrderResponse>builder()
        .data(orderService.getOrder(id))
        .build();
  }

  @PostMapping
  public ApiResponse<OrderResponse> postOrder(@RequestBody @Validated OrderRequest request) {
    return ApiResponse.<OrderResponse>builder()
        .data(orderService.createOrder(request))
        .build();
  }
}
