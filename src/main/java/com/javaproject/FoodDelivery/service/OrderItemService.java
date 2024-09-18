package com.javaproject.FoodDelivery.service;

import java.util.List;

import com.javaproject.FoodDelivery.entity.OrderItem;

public interface OrderItemService {
	OrderItem getOrderItemById(Integer orderItemId);
    List<OrderItem> getAllOrderItems();
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(Integer orderItemId, OrderItem orderItem);
    void deleteOrderItem(Integer orderItemId);
    List<OrderItem> findByOrderId(Integer orderId);
}
