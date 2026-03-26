package za.ac.cput.repository;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    private List<Review> reviews = new ArrayList<>();

    // CREATE
    public Review save(Review review) {
        reviews.add(review);
        return review;
    }

    //  READ (find by ID)
    public Review findById(String reviewId) {
        for (Review review : reviews) {
            if (review.getReviewId().equals(reviewId)) {
                return review;
            }
        }
        return null;
    }

    //  READ (get all)
    public List<Review> getAll() {
        return reviews;
    }

    // DELETE
    public boolean delete(String reviewId) {
        Review review = findById(reviewId);
        if (review != null) {
            reviews.remove(review);
            return true;
        }
        return false;
    }


}
