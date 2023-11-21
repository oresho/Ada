package com.payverdict.PayVerdict.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "ORDERITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private BigInteger itemPrice;
    private BigInteger totalOrderCost;
    private String description;
    private String quantity;
    private boolean isPayedFor;
    private String imageUrl;
    private String paymentLink;
}
