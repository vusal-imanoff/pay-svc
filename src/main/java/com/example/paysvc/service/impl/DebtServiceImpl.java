package com.example.paysvc.service.impl;

import com.example.paysvc.entity.Debt;
import com.example.paysvc.repository.DebtRepository;
import com.example.paysvc.service.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {
    private final DebtRepository debtRepository;
    @Override
    public Debt getDebtByAccountCode(int accountCode) {
        return debtRepository.findByAccountCode(accountCode);
    }
}
