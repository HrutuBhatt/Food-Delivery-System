package com.javaproject.FoodDelivery.service;

import java.util.List;

import com.javaproject.FoodDelivery.entity.User;


public interface UserService {
	  User getUserById(Integer userId);
	  List<User> getAllUsers();
	  User createUser(User user);
	  User updateUser(Integer userId, User user);
	  void deleteUser(Integer userId);
}
