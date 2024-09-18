package com.javaproject.FoodDelivery.service;

import java.util.List;

import com.javaproject.FoodDelivery.entity.Order;

public interface OrderService {
	Order getOrderById(Integer orderId);
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(Integer orderId, Order order);
    void deleteOrder(Integer orderId);
    public List<Order> findByTotalAmountGreaterThan(Integer amount);
    public List<Order> findByDeliveryManName(String deliveryManName);
    public List<Order> findAllByOrderByOrderDateDesc();
//    public List<Order> findByItem(String itemName); 
}
