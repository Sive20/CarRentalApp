package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;

import static org.junit.jupiter.api.Assertions.*;

class ReviewRepositoryTest {
    @Test
    public void testCreateReview(){
        ReviewRepository reviewRepository=new ReviewRepository();

        Review review = new Review.Builder()
                .setReviewId("CAA554-787")
                .setCustomerId("OP3232879")
                .setCarId("Car635")
                .setRating(4)
                .setComment("Very nice Car!")
                .build();

        Review saved = reviewRepository.save(review);

        assertNotNull(saved);
        assertEquals("CAA554-787", saved.getReviewId());
    }

    @Test
    public void testFindById() {

        ReviewRepository reviewRepository = new ReviewRepository();

        Review review = new Review.Builder()
                .setReviewId("CAA554-787")
                .setCustomerId("OP3232879")
                .setCarId("Car635")
                .setRating(4)
                .setComment("Very nice Car!")
                .build();

        reviewRepository.save(review);

        Review found = reviewRepository.findById("CAA554-787");

        assertNotNull(found);
        assertEquals("OP3232879", found.getCustomerId());
    }

    @Test
    public void testGetAll() {

        ReviewRepository reviewRepository = new ReviewRepository();

        Review review = new Review.Builder()
                .setReviewId("CAA554-787")
                .setCustomerId("OP3232879")
                .setCarId("Car635")
                .setRating(4)
                .setComment("Very nice Car!")
                .build();

        reviewRepository.save(review);

        java.util.List<Review> reviews = reviewRepository.getAll();

        assertFalse(reviews.isEmpty());
        assertEquals(1, reviews.size());
    }

    @Test
    public void testDelete() {

        ReviewRepository reviewRepository = new ReviewRepository();

        Review review = new Review.Builder()
                .setReviewId("CAA554-787")
                .setCustomerId("OP3232879")
                .setCarId("Car635")
                .setRating(4)
                .setComment("Very nice Car!")
                .build();

        reviewRepository.save(review);

        boolean deleted = reviewRepository.delete("CAA554-787");

        assertTrue(deleted);
        assertNull(reviewRepository.findById("CAA554-787"));
    }
}






