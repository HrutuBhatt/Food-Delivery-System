package com.javaproject.FoodDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.FoodDelivery.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>, CustomOrderRepository{
	List<Order> findAllByOrderByOrderDateDesc();
}
