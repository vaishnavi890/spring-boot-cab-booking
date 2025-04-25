package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return "User added successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/all")
    public List<User> getUsers() throws SQLException {
        return userService.fetchAllUsers();
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return "User updated!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return "User deleted!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }
}



