package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RatingRepository {

    public void addRating(Rating rating) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("INSERT INTO ratings(ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, rating.getRideId());
            ps.setInt(2, rating.getUserId());
            ps.setInt(3, rating.getDriverId());
            ps.setInt(4, rating.getRating());
            ps.setString(5, rating.getReview());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public List<Rating> getAllRatings() throws SQLException {
        List<Rating> ratings = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM ratings");

            while (rs.next()) {
                Rating rating = new Rating();
                rating.setRatingId(rs.getInt("rating_id"));
                rating.setRideId(rs.getInt("ride_id"));
                rating.setUserId(rs.getInt("user_id"));
                rating.setDriverId(rs.getInt("driver_id"));
                rating.setRating(rs.getInt("rating"));
                rating.setReview(rs.getString("review"));
                ratings.add(rating);
            }
        } finally {
            DBConnection.close(rs, st, con);
        }

        return ratings;
    }

    public void updateRating(Rating rating) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("UPDATE ratings SET rating=?, review=? WHERE rating_id=?");
            ps.setInt(1, rating.getRating());
            ps.setString(2, rating.getReview());
            ps.setInt(3, rating.getRatingId());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public void deleteRating(int ratingId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM ratings WHERE rating_id=?");
            ps.setInt(1, ratingId);
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }
}


