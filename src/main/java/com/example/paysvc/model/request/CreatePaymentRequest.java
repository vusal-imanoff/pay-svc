package com.example.paysvc.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreatePaymentRequest {

    private BigDecimal amount;
    private Integer userId;
    private Integer merchantId;
    private Integer debtId;
    private Integer accountCode;
}
