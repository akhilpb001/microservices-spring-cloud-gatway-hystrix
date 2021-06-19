package com.learning.microservice.orderservice.common;

import com.learning.microservice.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionResponse {

  private Order order;

  private double amount;

  private String transactionId;

  private String paymentStatus;

  private String message;
}
