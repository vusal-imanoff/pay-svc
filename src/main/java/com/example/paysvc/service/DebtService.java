package com.example.paysvc.service;

import com.example.paysvc.dto.Response.DebtResponse;

public interface DebtService {

    DebtResponse getDebtByAccountCode(int accountCode);
}
