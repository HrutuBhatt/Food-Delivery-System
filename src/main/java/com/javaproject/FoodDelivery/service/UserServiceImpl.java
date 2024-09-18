package com.javaproject.FoodDelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.FoodDelivery.entity.User;
import com.javaproject.FoodDelivery.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User getUserById(Integer userId) {
        return userDAO.findById(userId).orElse(null);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public User updateUser(Integer userId, User user) {
        // Check if user exists
        if (!userDAO.existsById(userId)) {
            return null;
        }
        user.setUserId(userId);
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        userDAO.deleteById(userId);
    }
}