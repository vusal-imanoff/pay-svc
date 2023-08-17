package com.example.paysvc.service.impl;

import com.example.paysvc.entity.DebtEntity;
import com.example.paysvc.mapper.DebtMapper;
import com.example.paysvc.model.response.DebtResponse;
import com.example.paysvc.exception.NotFoundException;
import com.example.paysvc.repository.DebtRepository;
import com.example.paysvc.service.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.paysvc.model.constant.ErrorMessages.debtNotFoundMessage;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {

    private final DebtRepository debtRepository;
    private final DebtMapper debtMapper;

    @Override
    public DebtResponse getDebtByAccountCode(Long accountCode) {
        return debtRepository.findByAccountCode(accountCode).map(debtMapper::modelToDTO).orElseThrow(() ->
                new NotFoundException(debtNotFoundMessage));
    }
}
