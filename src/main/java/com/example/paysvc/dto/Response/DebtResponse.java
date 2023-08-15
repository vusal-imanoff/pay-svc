package com.example.paysvc.dto.Response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
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
