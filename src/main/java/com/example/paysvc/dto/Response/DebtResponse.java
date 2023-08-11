package com.example.paysvc.dto.Response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebtResponse {
    private Long id;
    private int merchantId;
    private double debt;
    private long userId;
    private long accountCode;
}
