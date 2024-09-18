package com.javaproject.FoodDelivery.service;

import java.util.List;

import com.javaproject.FoodDelivery.entity.Payment;

public interface PaymentService {
	Payment getPaymentById(Integer paymentId);
    List<Payment> getAllPayments();
    Payment createPayment(Payment payment);
    Payment updatePayment(Integer paymentId, Payment payment);
    void deletePayment(Integer paymentId);
}
