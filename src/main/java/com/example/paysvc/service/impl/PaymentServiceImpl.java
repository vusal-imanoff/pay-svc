package com.example.paysvc.service.impl;

import com.example.paysvc.dto.Response.PaymentResponse;
import com.example.paysvc.entity.PaymentEntity;
import com.example.paysvc.enums.Status;
import com.example.paysvc.mapper.PaymentMapperImpl;
import com.example.paysvc.repository.PaymentRepository;
import com.example.paysvc.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapperImpl paymentMapper;
    @Override
    public Long save(PaymentEntity payment) {

        payment.setStatus(Status.Pending);
        paymentRepository.save(payment);
        return payment.getId();
    }

    @Override
    public PaymentEntity changeStatus(Long id) {
        PaymentEntity payment = paymentRepository.findPaymentById(id);
        payment.setStatus(Status.Accepted);
        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public List<PaymentResponse> getAll() {
        return paymentMapper.modelsToDTOs(paymentRepository.findAll());
    }
}
