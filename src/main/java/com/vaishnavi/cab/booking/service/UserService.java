package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void registerUser(User user) throws SQLException;

    List<User> fetchAllUsers() throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int userId) throws SQLException;
}



