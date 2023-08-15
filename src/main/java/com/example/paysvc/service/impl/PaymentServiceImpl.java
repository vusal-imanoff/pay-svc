package com.example.paysvc.service.impl;

import com.example.paysvc.dto.Request.CreatePaymentRequest;
import com.example.paysvc.dto.Response.PaymentResponse;
import com.example.paysvc.entity.PaymentEntity;
import com.example.paysvc.enums.Status;
import com.example.paysvc.exception.NotFoundException;
import com.example.paysvc.mapper.PaymentMapper;
import com.example.paysvc.repository.PaymentRepository;
import com.example.paysvc.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Long save(CreatePaymentRequest request) {

        PaymentEntity pay = paymentMapper.dtoToModel(request);
        pay.setStatus(Status.PENDING);
        String idempotency = "amount" + request.getAmount() + "userId" + request.getUserId() + "debtId" + request.getDebtId()
                + "accountCode" + request.getAccountCode() + Status.PENDING;

        PaymentResponse findPayment = paymentMapper.modelToDTO(paymentRepository.findByIdempotency(idempotency));

        if (findPayment == null) {
            pay.setIdempotency(idempotency);
            paymentRepository.save(pay);
            return pay.getId();
        }

        return 0L;
    }

    @Override
    public void changeStatus(Long id) {
        PaymentEntity payment = paymentRepository.findPaymentById(id);
        if (payment == null) {
            throw new NotFoundException("Payment is not found");
        }
        payment.setStatus(Status.ACCEPTED);
        paymentRepository.save(payment);
    }

    @Override
    public List<PaymentResponse> getAll() {
        return paymentMapper.modelsToDTOs(paymentRepository.findAll());
    }
}
