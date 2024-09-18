package com.javaproject.FoodDelivery.service;

import java.util.List;

import com.javaproject.FoodDelivery.entity.DeliveryMan;

public interface DeliveryManService {
	DeliveryMan getDeliveryManById(Integer deliverymanId);
	List<DeliveryMan> getAllDeliveryMen();
	DeliveryMan createDeliveryMan(DeliveryMan deliveryman);
	DeliveryMan updateDeliveryMan(Integer deliverymanId, DeliveryMan deliveryman);
	void deleteDeliveryMan(Integer deliverymanId);
}
