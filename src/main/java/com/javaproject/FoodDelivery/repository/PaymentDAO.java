package com.javaproject.FoodDelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.FoodDelivery.entity.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Integer>{

}
