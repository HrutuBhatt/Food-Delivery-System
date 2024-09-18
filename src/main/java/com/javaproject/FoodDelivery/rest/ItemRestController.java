package com.javaproject.FoodDelivery.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaproject.FoodDelivery.entity.Item;
import com.javaproject.FoodDelivery.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemRestController {

    private final ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable Integer itemId) {
        return itemService.getItemById(itemId);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/{itemId}")
    public Item updateItem(@PathVariable Integer itemId, @RequestBody Item item) {
        return itemService.updateItem(itemId, item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Integer itemId) {
        itemService.deleteItem(itemId);
    }
    
    @GetMapping("/available")
//    public List<Item> findAvailableItems(){
//    	return itemService.findAvailableItems();
//    }
    public List<Item> findByAvailableTrue(){
    	return itemService.findByAvailableTrue();
    }
}