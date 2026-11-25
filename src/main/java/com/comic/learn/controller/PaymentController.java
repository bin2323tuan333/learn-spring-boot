package com.comic.learn.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comic.learn.dto.request.PaymentRequest;
import com.comic.learn.dto.response.ApiResponse;
import com.comic.learn.dto.response.PaymentResponse;
import com.comic.learn.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
  private final PaymentService paymentService;

  @GetMapping
  public ApiResponse<List<PaymentResponse>> getAllPayments() {
    return ApiResponse.<List<PaymentResponse>>builder()
        .data(paymentService.getAllPayments())
        .build();
  }

  @PostMapping
  public ApiResponse<PaymentResponse> postPayment(@RequestBody @Validated PaymentRequest request) {
    return ApiResponse.<PaymentResponse>builder()
        .data(paymentService.createPayment(request))
        .build();
  }
}
