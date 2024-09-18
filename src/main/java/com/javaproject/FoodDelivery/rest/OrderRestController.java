package com.javaproject.FoodDelivery.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaproject.FoodDelivery.entity.Order;
import com.javaproject.FoodDelivery.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{orderId}")
    public Order updateOrder(@PathVariable Integer orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
    }
    
    @GetMapping("/amountGreaterThan")//@RequestParam("amount") Integer amount
    public List<Order> getOrdersWithAmountGreaterThan(@RequestParam("amount") String amount) {
    	Integer amt= Integer.parseInt(amount);
        return orderService.findByTotalAmountGreaterThan(amt);
    }

    @GetMapping("/deliveryman")
    public List<Order> findOrdersByDeliveryManName(@RequestParam("name") String deliveryManName) {
        return orderService.findByDeliveryManName(deliveryManName);
    }
    
    @GetMapping("/desc")
    public List<Order> findAllByOrderByOrderDateDesc(){
    	return orderService.findAllByOrderByOrderDateDesc();
    }
    
//    @GetMapping("/itemName")
//    public List<Order> findByItem(@RequestParam("name") String itemName){
//    	return orderService.findByItem(itemName);
//    }
}