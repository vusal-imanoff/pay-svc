package com.example.paysvc.service.impl;

import com.example.paysvc.dto.Response.DebtResponse;
import com.example.paysvc.entity.DebtEntity;
import com.example.paysvc.exception.NotFoundException;
import com.example.paysvc.repository.DebtRepository;
import com.example.paysvc.service.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {

    private final DebtRepository debtRepository;
    @Override
    public DebtResponse getDebtByAccountCode(int accountCode) {
        DebtResponse debtResponse = debtRepository.findByAccountCode(accountCode);
        if (debtResponse==null)
        {
            throw new NotFoundException("Debt is not found");
        }
        return debtResponse;
    }
}
