package com.javaproject.FoodDelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.FoodDelivery.entity.Payment;
import com.javaproject.FoodDelivery.repository.PaymentDAO;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDAO paymentDAO;

    @Autowired
    public PaymentServiceImpl(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    @Transactional
    public Payment getPaymentById(Integer paymentId) {
        return paymentDAO.findById(paymentId).orElse(null);
    }

    @Override
    @Transactional
    public List<Payment> getAllPayments() {
        return paymentDAO.findAll();
    }

    @Override
    @Transactional
    public Payment createPayment(Payment payment) {
        return paymentDAO.save(payment);
    }

    @Override
    @Transactional
    public Payment updatePayment(Integer paymentId, Payment payment) {
        // Check if payment exists
        if (!paymentDAO.existsById(paymentId)) {
            return null;
        }
        payment.setPaymentId(paymentId);
        return paymentDAO.save(payment);
    }

    @Override
    @Transactional
    public void deletePayment(Integer paymentId) {
        paymentDAO.deleteById(paymentId);
    }
}
