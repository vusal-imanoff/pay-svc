package com.example.paysvc.model.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DebtResponse {

    private Long id;
    private Integer merchantId;
    private BigDecimal debt;
    private Long userId;
    private Long accountCode;
}
