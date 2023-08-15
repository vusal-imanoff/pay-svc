package com.example.paysvc.entity;

import com.example.paysvc.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private int userId;
    private int merchantId;
    private int debtId;
    private int accountCode;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String idempotency;

}
