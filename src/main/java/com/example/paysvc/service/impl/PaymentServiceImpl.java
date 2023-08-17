package com.example.paysvc.service.impl;

import com.example.paysvc.model.constant.ErrorMessages;
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
import static com.example.paysvc.enums.Status.PENDING;
import static com.example.paysvc.model.constant.ErrorMessages.paymentExistsMessage;
import static com.example.paysvc.model.constant.ErrorMessages.paymentNotFoundMessage;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Long requestPayment(CreatePaymentRequest request) {

        var id = new AtomicReference<Long>();

        var key = String.format(
                "amount%suserId%sdebtId%saccountCode%s",
                request.getAmount(), request.getUserId(),request.getDebtId(),request.getAccountCode(),PENDING);

        paymentRepository.findByKey(key).ifPresentOrElse(entity -> {
            throw new NotFoundException(paymentExistsMessage);
        }, () -> {
            PaymentEntity pay = paymentMapper.dtoToModel(request);
            pay.setStatus(PENDING);
            pay.setKey(key);
            id.set(paymentRepository.save(pay).getId());
        });

        return id.get();
    }

    @Override
    public void submitPayment(Long id) {

        paymentRepository.findPaymentById(id).map(payment -> {
            payment.setStatus(ACCEPTED);
            paymentRepository.save(payment);
            return payment;
        }).orElseThrow(() -> new NotFoundException(paymentNotFoundMessage));
    }

    @Override
    public List<PaymentResponse> getAll() {
        return paymentMapper.modelsToDTOs(paymentRepository.findAll());
    }
}
