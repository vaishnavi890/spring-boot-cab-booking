package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;

import java.sql.SQLException;
import java.util.List;

public interface RatingService {
    void addRating(Rating rating) throws SQLException;

    List<Rating> getAllRatings() throws SQLException;

    void updateRating(Rating rating) throws SQLException;

    void deleteRating(int ratingId) throws SQLException;
}
