package com.javaproject.FoodDelivery.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaproject.FoodDelivery.entity.DeliveryMan;
import com.javaproject.FoodDelivery.service.DeliveryManService;

@RestController
@RequestMapping("/deliverymen")
public class DeliveryManRestController {

    private final DeliveryManService deliverymanService;

    @Autowired
    public DeliveryManRestController(DeliveryManService deliverymanService) {
        this.deliverymanService = deliverymanService;
    }

    @GetMapping("/{deliverymanId}")
    public DeliveryMan getDeliveryManById(@PathVariable Integer deliverymanId) {
        return deliverymanService.getDeliveryManById(deliverymanId);
    }

    @GetMapping
    public List<DeliveryMan> getAllDeliveryMen() {
        return deliverymanService.getAllDeliveryMen();
    }

    @PostMapping
    public DeliveryMan createDeliveryMan(@RequestBody DeliveryMan deliveryman) {
        return deliverymanService.createDeliveryMan(deliveryman);
    }

    @PutMapping("/{deliverymanId}")
    public DeliveryMan updateDeliveryMan(@PathVariable Integer deliverymanId, @RequestBody DeliveryMan deliveryman) {
        return deliverymanService.updateDeliveryMan(deliverymanId, deliveryman);
    }

    @DeleteMapping("/{deliverymanId}")
    public void deleteDeliveryMan(@PathVariable Integer deliverymanId) {
        deliverymanService.deleteDeliveryMan(deliverymanId);
    }
}