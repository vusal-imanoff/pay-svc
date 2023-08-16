package com.example.paysvc.entity;

import com.example.paysvc.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PAYMENTS")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private Integer userId;

    private Integer merchantId;

    private Integer debtId;

    private Integer accountCode;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String key;

}
