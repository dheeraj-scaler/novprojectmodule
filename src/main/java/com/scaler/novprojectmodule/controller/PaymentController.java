package com.scaler.novprojectmodule.controller;

import com.scaler.novprojectmodule.dto.PaymentRequestDto;
import com.scaler.novprojectmodule.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> createPaymentLink(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
        String paymentLink  = paymentService.makePayment(paymentRequestDto.getOrderId(), paymentRequestDto.getAmount());
        return new ResponseEntity<>(paymentLink, HttpStatus.OK);

    }

    @PostMapping("/webhook")
    public void handleWebhook() {
        System.out.println("Webhook revecied here");
        return;
    }
}
