package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;
import com.vaishnavi.cab.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) throws SQLException {
        userRepository.addUser(user);
    }

    @Override
    public List<User> fetchAllUsers() throws SQLException {
        return userRepository.getAllUsers();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        userRepository.deleteUser(userId);
    }

    @Override
    public User updateUser(int id, User user) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User createUser(User user) {
        return null;
    }
}



