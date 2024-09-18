package com.javaproject.FoodDelivery.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaproject.FoodDelivery.entity.OrderItem;
import com.javaproject.FoodDelivery.service.OrderItemService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemRestController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemRestController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable Integer orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @PutMapping("/{orderItemId}")
    public OrderItem updateOrderItem(@PathVariable Integer orderItemId, @RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(orderItemId, orderItem);
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Integer orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
    
    @GetMapping("/getItems/{orderId}")
    List<OrderItem> findByOrderId(@PathVariable Integer orderId){
    	return orderItemService.findByOrderId(orderId);

    }
}