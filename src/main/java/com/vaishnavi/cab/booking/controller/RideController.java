package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/book")
    public String bookRide(@RequestBody Ride ride) {
        try {
            rideService.bookRide(ride);
            return "Ride booked successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/all")
    public List<Ride> getAllRides() throws SQLException {
        return rideService.getRides();
    }

    @PutMapping("/update")
    public String updateRide(@RequestBody Ride ride) {
        try {
            rideService.updateRide(ride);
            return "Ride updated successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRide(@PathVariable int id) {
        try {
            rideService.deleteRide(id);
            return "Ride deleted successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }
}


