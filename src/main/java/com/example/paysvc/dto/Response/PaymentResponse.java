package com.example.paysvc.dto.Response;

import com.example.paysvc.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {

    private Long id;
    private double amount;
    private int userId;
    private int merchantId;
    private int debtId;
    private int accountCode;
    private String idempotency;
    @Enumerated(EnumType.STRING)
    private Status status;
}
