package com.example.paysvc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "DEBTS")
public class DebtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer merchantId;

    private BigDecimal debt;

    private Long userId;

    private Long accountCode;

}
