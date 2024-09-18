package com.javaproject.FoodDelivery.service;

import java.util.List;

import com.javaproject.FoodDelivery.entity.Item;

public interface ItemService {
	  Item getItemById(Integer itemId);
	  List<Item> getAllItems();
	  Item createItem(Item item);
	  Item updateItem(Integer itemId, Item item);
	  void deleteItem(Integer itemId);
//	  List<Item> findAvailableItems();
	  List<Item> findByAvailableTrue();
}
