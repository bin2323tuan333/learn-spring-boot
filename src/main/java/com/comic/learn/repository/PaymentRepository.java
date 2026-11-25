package com.comic.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comic.learn.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
