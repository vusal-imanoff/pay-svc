package com.example.paysvc.service;

import com.example.paysvc.model.request.CreatePaymentRequest;
import com.example.paysvc.model.response.PaymentResponse;

import java.util.List;

public interface PaymentService {

    Long requestPayment(CreatePaymentRequest payment);

    void submitPayment(Long debtId);

    List<PaymentResponse> getAll();
}
