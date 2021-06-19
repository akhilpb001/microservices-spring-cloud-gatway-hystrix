package com.learning.microservice.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.microservice.orderservice.common.Payment;
import com.learning.microservice.orderservice.common.TransactionRequest;
import com.learning.microservice.orderservice.common.TransactionResponse;
import com.learning.microservice.orderservice.entity.Order;
import com.learning.microservice.orderservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

  private Logger logger = LoggerFactory.getLogger(OrderService.class);

  @Autowired
  private OrderRepository repository;

  @Autowired
  @Lazy
  private RestTemplate restTemplate;

  @Value("${microservice.payment-service.endpoints.endpoint.uri}")
  private String PAYMENT_ENDPOINT_URL;

  public TransactionResponse saveOrder(TransactionRequest request) {
    Order order = request.getOrder();
    Order orderResponse = repository.save(order);
    logMessage("OrderService - transaction request: {}", request);
    Payment payment = new Payment();
    payment.setOrderId(orderResponse.getId());
    payment.setAmount(orderResponse.getPrice());
    // save payment to payment-service using rest call
    Payment paymentResponse = restTemplate.postForObject(PAYMENT_ENDPOINT_URL, payment, Payment.class);
    String responseMessage = paymentResponse.getPaymentStatus().equals("success")
        ? "Payment successful and order placed successfully."
        : "Payment failed, but order added to cart.";
    logMessage("OrderService - response from payment service: {}", paymentResponse);
    TransactionResponse response = new TransactionResponse(orderResponse, paymentResponse.getAmount(),
        paymentResponse.getTransactionId(), paymentResponse.getPaymentStatus(), responseMessage);
    logMessage("OrderService - transaction response: {}", response);
    return response;
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
