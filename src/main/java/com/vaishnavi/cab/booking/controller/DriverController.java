package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public String addDriver(@RequestBody Driver driver) {
        try {
            driverService.registerDriver(driver);
            return "Driver registered!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/all")
    public List<Driver> getAllDrivers() throws SQLException {
        return driverService.getDrivers();
    }

    @PutMapping("/update")
    public String updateDriver(@RequestBody Driver driver) {
        try {
            driverService.updateDriver(driver);
            return "Driver updated!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDriver(@PathVariable int id) {
        try {
            driverService.deleteDriver(id);
            return "Driver deleted!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }
}



