package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFactoryTest {
    @Test
    void testCreateReviewSuccess() {

        Review review = ReviewFactory.createReview(
                "CAA554-787",
                "CAA554-787",
                "Car635",
                5,
                "Great car!"
        );

        assertNotNull(review);
        assertEquals("CAA554-787", review.getReviewId());
        assertEquals("CAA554-787", review.getCustomerId());
        assertEquals("Car635", review.getCarId());
        assertEquals(5, review.getRating());
        assertEquals("Great car!", review.getComment());
    }

    @Test
    void testCreateReviewWithNullValues() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReviewFactory.createReview(null, "CAA554-787", "Car635", 5, "Very Nice Car");
        });

        assertEquals("IDs cannot be null", exception.getMessage());
    }

    @Test
    void testCreateReviewInvalidRating() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReviewFactory.createReview("CAA554-987", "OP3232879", "Car2", 8, "Bad rating");
        });

        assertEquals("Rating must be between 1 and 5", exception.getMessage());
    }

}