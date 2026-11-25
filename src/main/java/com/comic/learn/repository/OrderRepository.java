package com.comic.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comic.learn.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  boolean existsByComicId(Long id);
}
