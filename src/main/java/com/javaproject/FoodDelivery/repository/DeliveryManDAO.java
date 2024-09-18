package com.javaproject.FoodDelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.FoodDelivery.entity.DeliveryMan;

public interface DeliveryManDAO extends JpaRepository<DeliveryMan, Integer>{
	
}
