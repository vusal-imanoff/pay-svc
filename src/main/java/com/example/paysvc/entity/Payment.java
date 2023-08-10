package com.example.paysvc.entity;

import com.example.paysvc.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private int userId;
    private int mergentId;
    private int debtId;
    private int accountCode;

    @Enumerated(EnumType.STRING)
    private Status status;
}
