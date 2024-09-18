package com.javaproject.FoodDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaproject.FoodDelivery.entity.OrderItem;

public interface OrderItemDAO extends JpaRepository<OrderItem, Integer>{
	@Query("SELECT oi FROM OrderItem oi WHERE oi.order.orderId = :orderId")
	List<OrderItem> findByOrderId(Integer orderId);
}
