package com.example.paysvc.service;

import com.example.paysvc.entity.Payment;

import java.util.List;

public interface PaymentService {
    public Long save(Payment payment);
    public Payment changeStatus(Long debtId);
    public List<Payment> getAll();
}
