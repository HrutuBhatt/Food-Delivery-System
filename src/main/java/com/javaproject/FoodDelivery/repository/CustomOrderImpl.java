package com.javaproject.FoodDelivery.repository;

import java.util.List;

import com.javaproject.FoodDelivery.entity.Order;

import jakarta.persistence.EntityManager;

public class CustomOrderImpl implements CustomOrderRepository{
	
	private EntityManager entityManager;
	@Override
	public List<Order> findByTotalAmountGreaterThan(Integer amount) {
		return entityManager.createQuery("SELECT o FROM Order o WHERE o.totalAmount > :amount", Order.class)
                .setParameter("amount", amount)
                .getResultList();
	}
	
	public List<Order> findByDeliveryManName(String deliveryManName){
		return entityManager.createQuery("SELECT o FROM Order o JOIN o.deliveryMan d WHERE d.name = :deliveryManName", Order.class)
				.setParameter("deliveryManName", deliveryManName)
				.getResultList();
		
	}
	
//	public List<Order> findByItem(String itemName){
//		return entityManager.createQuery("SELECT o FROM Order o JOIN o.orderItems oi JOIN oi.item i WHERE i.itemName = :itemName", Order.class)
//				.setParameter("itemName", itemName)
//				.getResultList();
//	}

}
