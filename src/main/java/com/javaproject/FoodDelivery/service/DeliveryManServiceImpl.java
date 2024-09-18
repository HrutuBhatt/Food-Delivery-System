package com.javaproject.FoodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.FoodDelivery.entity.DeliveryMan;
import com.javaproject.FoodDelivery.repository.DeliveryManDAO;

@Service
public class DeliveryManServiceImpl implements DeliveryManService {

    private final DeliveryManDAO deliverymanDAO;

    @Autowired
    public DeliveryManServiceImpl(DeliveryManDAO deliverymanDAO) {
        this.deliverymanDAO = deliverymanDAO;
    }

    @Override
    @Transactional
    public DeliveryMan getDeliveryManById(Integer deliverymanId) {
        return deliverymanDAO.findById(deliverymanId).orElse(null);
    }

    @Override
    @Transactional
    public List<DeliveryMan> getAllDeliveryMen() {
        return deliverymanDAO.findAll();
    }

    @Override
    @Transactional
    public DeliveryMan createDeliveryMan(DeliveryMan deliveryman) {
        return deliverymanDAO.save(deliveryman);
    }

    @Override
    @Transactional
    public DeliveryMan updateDeliveryMan(Integer deliverymanId, DeliveryMan deliveryman) {
        // Check if deliveryman exists
        if (!deliverymanDAO.existsById(deliverymanId)) {
            return null;
        }
        deliveryman.setDeliveryManId(deliverymanId);
        return deliverymanDAO.save(deliveryman);
    }

    @Override
    @Transactional
    public void deleteDeliveryMan(Integer deliverymanId) {
        deliverymanDAO.deleteById(deliverymanId);
    }
}