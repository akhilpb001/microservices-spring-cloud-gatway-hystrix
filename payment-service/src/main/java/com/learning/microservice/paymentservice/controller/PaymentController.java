package com.learning.microservice.paymentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learning.microservice.paymentservice.entity.Payment;
import com.learning.microservice.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  private PaymentService service;

  @PostMapping("/doPayment")
  public Payment doPayment(@RequestBody Payment payment) {
    return service.doPayment(payment);
  }

  @GetMapping("/{orderId}")
  public Payment findPaymentByOrderId(@PathVariable int orderId) {
    return  service.findPaymentByOrderId(orderId);
  }
}
