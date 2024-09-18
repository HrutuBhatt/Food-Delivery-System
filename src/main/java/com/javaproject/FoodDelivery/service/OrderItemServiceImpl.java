package com.javaproject.FoodDelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.FoodDelivery.entity.OrderItem;
import com.javaproject.FoodDelivery.repository.OrderItemDAO;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemDAO orderItemDAO;

    @Autowired
    public OrderItemServiceImpl(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }

    @Override
    @Transactional
    public OrderItem getOrderItemById(Integer orderItemId) {
        return orderItemDAO.findById(orderItemId).orElse(null);
    }

    @Override
    @Transactional
    public List<OrderItem> getAllOrderItems() {
        return orderItemDAO.findAll();
    }

    @Override
    @Transactional
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemDAO.save(orderItem);
    }

    @Override
    @Transactional
    public OrderItem updateOrderItem(Integer orderItemId, OrderItem orderItem) {
        // Check if orderItem exists
        if (!orderItemDAO.existsById(orderItemId)) {
            return null;
        }
        orderItem.setOrderItemId(orderItemId);
        return orderItemDAO.save(orderItem);
    }

    @Override
    @Transactional
    public void deleteOrderItem(Integer orderItemId) {
        orderItemDAO.deleteById(orderItemId);
    }
    
    @Override
    @Transactional
	public
    List<OrderItem> findByOrderId(Integer orderId){
    	return orderItemDAO.findByOrderId(orderId);

    }
}
