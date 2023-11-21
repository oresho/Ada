package com.payverdict.PayVerdict.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "MERCHANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerEmail;
    private String passwordHash;
    private String businessName;
    private String businessAddress;
    private String businessType;
    private String infoEmail;
    private String contactNo;
    private String logoUrl;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaleItem> merchantStore;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderHistory;
}
