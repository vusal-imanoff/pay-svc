package com.example.paysvc.service;

import com.example.paysvc.dto.Response.PaymentResponse;
import com.example.paysvc.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    Long save(PaymentEntity payment);
    PaymentEntity changeStatus(Long debtId);
    List<PaymentResponse> getAll();
}
