package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;
import com.vaishnavi.cab.booking.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void addRating(Rating rating) throws SQLException {
        ratingRepository.addRating(rating);
    }

    @Override
    public List<Rating> getAllRatings() throws SQLException {
        return ratingRepository.getAllRatings();
    }

    @Override
    public void updateRating(Rating rating) throws SQLException {
        ratingRepository.updateRating(rating);
    }

    @Override
    public void deleteRating(int ratingId) throws SQLException {
        ratingRepository.deleteRating(ratingId);
    }
}



