package za.ac.cput.factory;

import za.ac.cput.domain.Review;

public class ReviewFactory {
    public static Review createReview(String reviewId,
                                      String customerId,
                                      String carId,
                                      int rating,
                                      String comment) {

        // Validate IDs
        if (reviewId == null || customerId == null || carId == null) {
            throw new IllegalArgumentException("IDs cannot be null");
        }

        // Validate rating
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        // Build object using Builder Pattern
        return new Review.Builder()
                .setReviewId(reviewId)
                .setCustomerId(customerId)
                .setCarId(carId)
                .setRating(rating)
                .setComment(comment)
                .build();
    }

}
