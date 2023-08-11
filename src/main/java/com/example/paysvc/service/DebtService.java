package com.example.paysvc.service;

import com.example.paysvc.dto.Response.DebtResponse;
import com.example.paysvc.entity.DebtEntity;

public interface DebtService {
    public DebtResponse getDebtByAccountCode(int accountCode);
}
