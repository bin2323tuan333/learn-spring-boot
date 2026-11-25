package com.comic.learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.comic.learn.dto.request.OrderRequest;
import com.comic.learn.dto.response.OrderResponse;
import com.comic.learn.entity.Comic;
import com.comic.learn.entity.Order;
import com.comic.learn.exception.AppException;
import com.comic.learn.exception.ErrorCode;
import com.comic.learn.repository.ComicRepository;
import com.comic.learn.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final ComicRepository comicRepository;

  public List<OrderResponse> getAllOrders() {
    List<Order> orders = orderRepository.findAll();
    return orders.stream()
        .map(this::toOrderResponse)
        .toList();
  }

  public OrderResponse getOrder(Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
    return toOrderResponse(order);
  }

  public OrderResponse createOrder(OrderRequest request) {
    Comic comic = comicRepository.findById(request.getComicId())
        .orElseThrow(() -> new AppException(ErrorCode.COMIC_NOT_FOUND));
    if (request.getQuantity() > comic.getStock()) {
      throw new AppException(ErrorCode.OUT_OF_STOCK);
    }
    Order order = toOrder(request);
    order.setTotalPrice(comic.getPrice() * request.getQuantity());
    comic.setStock(comic.getStock() - request.getQuantity());
    comicRepository.save(comic);
    order = orderRepository.save(order);
    return toOrderResponse(order);
  }

  private OrderResponse toOrderResponse(Order order) {
    return OrderResponse.builder()
        .id(order.getId())
        .customerName(order.getCustomerName())
        .comicId(order.getComicId())
        .quantity(order.getQuantity())
        .totalPrice(order.getTotalPrice())
        .status(order.getStatus())
        .createdAt(order.getCreatedAt())
        .build();
  }

  private Order toOrder(OrderRequest orderRequest) {
    return Order.builder()
        .comicId(orderRequest.getComicId())
        .quantity(orderRequest.getQuantity())
        .customerName(orderRequest.getCustomerName())
        .build();
  }
}
