package com.example.paysvc.service.impl;

import com.example.paysvc.model.request.CreatePaymentRequest;
import com.example.paysvc.model.response.PaymentResponse;
import com.example.paysvc.entity.PaymentEntity;
import com.example.paysvc.enums.Status;
import com.example.paysvc.exception.NotFoundException;
import com.example.paysvc.mapper.PaymentMapper;
import com.example.paysvc.repository.PaymentRepository;
import com.example.paysvc.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.paysvc.enums.Status.ACCEPTED;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Long save(CreatePaymentRequest request) {

        AtomicReference<Long> id = new AtomicReference<>();

        String key = "amount" + request.getAmount() + "userId" + request.getUserId() + "debtId" + request.getDebtId() + "accountCode" + request.getAccountCode() + Status.PENDING;

        paymentRepository.findByKey(key).ifPresentOrElse(entity -> {
            throw new NotFoundException("Payment is exists");
        }, () -> {
            PaymentEntity pay = paymentMapper.dtoToModel(request);
            pay.setStatus(Status.PENDING);
            pay.setKey(key);
            id.set(paymentRepository.save(pay).getId());
        });

        return id.get();
    }

    @Override
    public void changeStatus(Long id) {

        paymentRepository.findPaymentById(id).map(payment -> {
            payment.setStatus(ACCEPTED);
            paymentRepository.save(payment);
            return payment;
        }).orElseThrow(() -> new NotFoundException("Payment is not found"));
    }

    @Override
    public List<PaymentResponse> getAll() {
        return paymentMapper.modelsToDTOs(paymentRepository.findAll());
    }
}
