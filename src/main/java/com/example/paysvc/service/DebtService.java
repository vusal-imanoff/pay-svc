package com.example.paysvc.service;

import com.example.paysvc.model.response.DebtResponse;

public interface DebtService {

    DebtResponse getDebtByAccountCode(Long accountCode);
}
