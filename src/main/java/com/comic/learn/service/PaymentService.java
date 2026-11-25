package com.comic.learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.comic.learn.dto.request.PaymentRequest;
import com.comic.learn.dto.response.PaymentResponse;
import com.comic.learn.entity.Order;
import com.comic.learn.entity.Payment;
import com.comic.learn.enums.OrderStatus;
import com.comic.learn.enums.PaymentStatus;
import com.comic.learn.exception.AppException;
import com.comic.learn.exception.ErrorCode;
import com.comic.learn.repository.OrderRepository;
import com.comic.learn.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
  private final PaymentRepository paymentRepository;
  private final OrderRepository orderRepository;

  public List<PaymentResponse> getAllPayments() {
    List<Payment> payments = paymentRepository.findAll();
    return payments.stream()
        .map(this::toPaymentResponse)
        .toList();
  }

  public PaymentResponse createPayment(PaymentRequest request) {
    Order order = orderRepository.findById(request.getOrderId())
        .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
    if (!order.getStatus().equals(OrderStatus.PENDING.name())) {
      throw new AppException(ErrorCode.ORDER_IS_NOT_PENDING);
    }

    if (!request.getAmount().equals(order.getTotalPrice())) {
      Payment payment = Payment.builder()
          .amount(request.getAmount())
          .method(request.getMethod())
          .orderId(order.getId())
          .status(PaymentStatus.FAILED.name())
          .build();
      paymentRepository.save(payment);
      return toPaymentResponse(payment);
    }

    order.setStatus(OrderStatus.PAID.name());
    orderRepository.save(order);
    Payment payment = Payment.builder()
        .amount(request.getAmount())
        .method(request.getMethod())
        .orderId(order.getId())
        .status(PaymentStatus.SUCCESS.name())
        .build();
    paymentRepository.save(payment);
    return toPaymentResponse(payment);
  }

  private PaymentResponse toPaymentResponse(Payment payment) {
    return PaymentResponse.builder()
        .id(payment.getId())
        .amount(payment.getAmount())
        .method(payment.getMethod())
        .orderId(payment.getOrderId())
        .status(payment.getStatus())
        .paidAt(payment.getPaidAt())
        .build();
  }
}
