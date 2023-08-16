package com.example.paysvc.service;

import com.example.paysvc.model.request.CreatePaymentRequest;
import com.example.paysvc.model.response.PaymentResponse;

import java.util.List;

public interface PaymentService {

    Long save(CreatePaymentRequest payment);

    void changeStatus(Long debtId);

    List<PaymentResponse> getAll();
}
