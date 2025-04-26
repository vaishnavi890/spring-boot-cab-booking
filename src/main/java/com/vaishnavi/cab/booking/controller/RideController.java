package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/book")
    public Ride bookRide(@RequestBody Ride ride) throws SQLException {
        return rideService.bookRide(ride);
    }

    @GetMapping("/all")
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public Ride getRideById(@PathVariable int id) {
        return rideService.getRideById(id);
    }

    @PutMapping("/update/{id}")
    public Ride updateRide(@PathVariable int id, @RequestBody Ride ride) {
        return rideService.updateRide(id, ride);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRide(@PathVariable int id) throws SQLException {
        rideService.deleteRide(id);
        return "Ride deleted successfully!";
    }
}


