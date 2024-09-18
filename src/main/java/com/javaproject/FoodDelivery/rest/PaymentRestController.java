package com.javaproject.FoodDelivery.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaproject.FoodDelivery.entity.Payment;
import com.javaproject.FoodDelivery.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentRestController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable Integer paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{paymentId}")
    public Payment updatePayment(@PathVariable Integer paymentId, @RequestBody Payment payment) {
        return paymentService.updatePayment(paymentId, payment);
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable Integer paymentId) {
        paymentService.deletePayment(paymentId);
    }
}