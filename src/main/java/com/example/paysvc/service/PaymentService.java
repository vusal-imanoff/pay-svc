package com.example.paysvc.service;

import com.example.paysvc.dto.Request.CreatePaymentRequest;
import com.example.paysvc.dto.Response.PaymentResponse;
import com.example.paysvc.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {

    Long save(CreatePaymentRequest payment);
    void changeStatus(Long debtId);
    List<PaymentResponse> getAll();
}
