package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/add")
    public String addRating(@RequestBody Rating rating) {
        try {
            ratingService.addRating(rating);
            return "Rating added successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/all")
    public List<Rating> getAllRatings() throws SQLException {
        return ratingService.getAllRatings();
    }

    @PutMapping("/update")
    public String updateRating(@RequestBody Rating rating) {
        try {
            ratingService.updateRating(rating);
            return "Rating updated successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRating(@PathVariable int id) {
        try {
            ratingService.deleteRating(id);
            return "Rating deleted successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }
}



