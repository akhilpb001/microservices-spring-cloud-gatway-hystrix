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
public class TransactionRequest {

  private Order order;

  private Payment payment;
}
