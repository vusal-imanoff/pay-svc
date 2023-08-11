package com.example.paysvc.dto.Request;

import com.example.paysvc.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {
    private double amount;
    private int userId;
    private int merchantId;
    private int debtId;
    private int accountCode;

}
