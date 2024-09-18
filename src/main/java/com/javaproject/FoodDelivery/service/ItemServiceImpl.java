
package com.javaproject.FoodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.FoodDelivery.entity.Item;
import com.javaproject.FoodDelivery.repository.ItemDAO;
import com.javaproject.FoodDelivery.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemDAO itemDAO;

    @Autowired
    public ItemServiceImpl(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    @Transactional
    public Item getItemById(Integer itemId) {
        return itemDAO.findById(itemId).orElse(null);
    }

    @Override
    @Transactional
    public List<Item> getAllItems() {
        return itemDAO.findAll();
    }

    @Override
    @Transactional
    public Item createItem(Item item) {
        return itemDAO.save(item);
    }

    @Override
    @Transactional
    public Item updateItem(Integer itemId, Item item) {
        // Check if item exists
        if (!itemDAO.existsById(itemId)) {
            return null;
        }
        item.setItemId(itemId);
        return itemDAO.save(item);
    }

    @Override
    @Transactional
    public void deleteItem(Integer itemId) {
    	itemDAO.deleteById(itemId);
    }
    
    @Override
    @Transactional
//    public List<Item> findAvailableItems(){
//    	return itemDAO.findAvailableItems();
//    }
    public List<Item> findByAvailableTrue(){
    	return itemDAO.findByAvailableTrue();
    }
    
}