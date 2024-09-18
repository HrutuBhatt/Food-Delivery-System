package com.javaproject.FoodDelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaproject.FoodDelivery.entity.Order;
import com.javaproject.FoodDelivery.entity.OrderItem;
import com.javaproject.FoodDelivery.repository.OrderDAO;
import com.javaproject.FoodDelivery.repository.OrderItemDAO;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public Order getOrderById(Integer orderId) {
        return orderDAO.findById(orderId).orElse(null);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderDAO.findAll();
    }

    @Override
    @Transactional
    public Order createOrder(@RequestBody Order order) {
    	Integer totalAmount=0;
    	for(OrderItem item: order.getOrderItems()) {
    		totalAmount += item.getTotalPrice();
    	}
    	order.setTotalAmount(totalAmount);
        return orderDAO.save(order);
    }

    @Override
    @Transactional
    public Order updateOrder(Integer orderId, Order order) {
        // Check if order exists
        if (!orderDAO.existsById(orderId)) {
            return null;
        }
        order.setOrderId(orderId);
        return orderDAO.save(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Integer orderId) {
        orderDAO.deleteById(orderId);
    }
    
    @Override
    @Transactional
    public List<Order> findByTotalAmountGreaterThan(Integer amount) {
        return orderDAO.findByTotalAmountGreaterThan(amount);
    }
    
    @Override
    @Transactional
    public List<Order> findByDeliveryManName(String deliveryManName) {
        return orderDAO.findByDeliveryManName(deliveryManName);
    }
    
    @Override
    @Transactional
	public List<Order> findAllByOrderByOrderDateDesc(){
    	return orderDAO.findAllByOrderByOrderDateDesc();
    }
    
//    @Override
//    @Transactional
//	public
//    List<Order> findByItem(String itemName){
//    	return orderDAO.findByItem(itemName);
//    }
    
}
