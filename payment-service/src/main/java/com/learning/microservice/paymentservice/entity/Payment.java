package com.learning.microservice.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments", schema = "payment_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_id")
  private int paymentId;

  @Column(name = "payment_status")
  private String paymentStatus;

  @Column(name = "transaction_id")
  private String transactionId;

  @Column(name = "order_id")
  private int orderId;

  private double amount;
}
