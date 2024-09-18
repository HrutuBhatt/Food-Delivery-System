package com.javaproject.FoodDelivery.repository;

import java.util.List;

import com.javaproject.FoodDelivery.entity.Order;

public interface CustomOrderRepository {
	
	 List<Order> findByTotalAmountGreaterThan(Integer amount);
	 List<Order> findByDeliveryManName(String deliveryManName);
//	 List<Order> findByItem(String itemName); 
}