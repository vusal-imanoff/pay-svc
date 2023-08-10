package com.example.paysvc.service.impl;

import com.example.paysvc.entity.Payment;
import com.example.paysvc.enums.Status;
import com.example.paysvc.repository.PaymentRepository;
import com.example.paysvc.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    @Override
    public Long save(Payment payment) {

        payment.setStatus(Status.Pending);
        paymentRepository.save(payment);
        return payment.getId();
    }

    @Override
    public Payment changeStatus(Long id) {
        Payment payment = paymentRepository.findPaymentById(id);
        payment.setStatus(Status.Accepted);
        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}
