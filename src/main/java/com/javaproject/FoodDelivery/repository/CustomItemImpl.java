package com.javaproject.FoodDelivery.repository;

import java.util.List;


import com.javaproject.FoodDelivery.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CustomItemImpl implements CustomItemRepository{
//	private EntityManager entityManager;
//	@Override 
//	public List<Item> findAvailableItems(){
////		TypedQuery<Item> theQuery = 
////				entityManager.createQuery("SELECT i FROM items i WHERE i.available = true", Item.class);
////		List<Item> items = theQuery.getResultList();
//		
//
//		return entityManager.createQuery("SELECT o FROM Item o WHERE o.available = :available", Item.class)
//                .setParameter("available", true)
//                .getResultList();
//	}

}
