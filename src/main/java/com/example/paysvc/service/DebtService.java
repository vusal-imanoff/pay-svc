package com.example.paysvc.service;

import com.example.paysvc.entity.Debt;

public interface DebtService {
    public Debt getDebtByAccountCode(int accountCode);
}
