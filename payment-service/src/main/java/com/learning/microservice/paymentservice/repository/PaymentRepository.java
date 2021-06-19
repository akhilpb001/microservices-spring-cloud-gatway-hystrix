package com.learning.microservice.paymentservice.repository;

import com.learning.microservice.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
  Payment findByOrderId(int orderId);
}
