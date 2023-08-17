package com.example.paysvc.controller;

import com.example.paysvc.model.request.CreatePaymentRequest;
import com.example.paysvc.model.response.DebtResponse;
import com.example.paysvc.model.response.PaymentResponse;
import com.example.paysvc.service.DebtService;
import com.example.paysvc.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/pay")
public class PayController {

    private final DebtService debtService;
    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentResponse> getAll() {
        return paymentService.getAll();
    }


    @GetMapping("/{accountCode}")
    public DebtResponse getDebtByAccountCode(@PathVariable Long accountCode) {
        return debtService.getDebtByAccountCode(accountCode);
    }

    @PostMapping
    public Long requestPayment(@RequestBody CreatePaymentRequest request) {
        return paymentService.requestPayment(request);
    }

    @PostMapping("/{id}")
    public void submitPayment(@PathVariable Long id) {
        paymentService.submitPayment(id);
    }
}


