package com.javaproject.FoodDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.FoodDelivery.entity.Item;

public interface ItemDAO extends JpaRepository<Item, Integer>,CustomItemRepository{
	List<Item> findByAvailableTrue();	
}
