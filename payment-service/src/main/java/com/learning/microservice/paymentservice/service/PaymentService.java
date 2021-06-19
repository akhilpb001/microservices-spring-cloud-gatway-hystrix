package com.learning.microservice.paymentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.microservice.paymentservice.entity.Payment;
import com.learning.microservice.paymentservice.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

  private Logger logger = LoggerFactory.getLogger(PaymentService.class);

  @Autowired
  private PaymentRepository repository;

  public Payment doPayment(Payment payment) {
    payment.setTransactionId(UUID.randomUUID().toString());
    payment.setPaymentStatus(getRandomPaymentStatus());
    logMessage("PaymentService - payment request: {}", payment);
    return repository.save(payment);
  }

  private String getRandomPaymentStatus() {
    // api should be 3rd party payment gateway (paypal, paytm...etc)
    return new Random().nextBoolean() ? "success" : "failure";
  }

  public Payment findPaymentByOrderId(int orderId) {
    Payment payment = repository.findByOrderId(orderId);
    logMessage("PaymentService - findPaymentByOrderId: {}", payment);
    return payment;
  }

  private void logMessage(String message, Object obj) {
    try {
      logger.info(message, new ObjectMapper().writeValueAsString(obj));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      logger.info(message, obj.toString());
    }
  }
}
