package com.example.paysvc.model.response;

import com.example.paysvc.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentResponse {

    private Long id;
    private BigDecimal amount;
    private Integer userId;
    private Integer merchantId;
    private Integer debtId;
    private Integer accountCode;
    private String idempotency;
    private Status key;
}
