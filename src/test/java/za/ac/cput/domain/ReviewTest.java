package za.ac.cput.domain;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

class ReviewTest {
    @Test
    public void testCreateReview() {

        // Create Review using Builder
        Review review = new Review.Builder()
                .setReviewId("BAA234-565")
                .setCustomerId("OP34456451")
                .setCarId("Car635")
                .setRating(5)
                .setComment("Very nice Car!")
                .build();

        // Assertions
        assertNotNull(review);
        assertEquals("BAA234-565", review.getReviewId());
        assertEquals("OP34456451", review.getCustomerId());
        assertEquals("Car635", review.getCarId());
        assertEquals(5, review.getRating());
        assertEquals("Very nice Car!", review.getComment());
    }

    @Test
    public void testToString() {

        Review review = new Review.Builder()
                .setReviewId("CAA554-787")
                .setCustomerId("OP3232879")
                .setCarId("Car5")
                .setRating(5)
                .setComment("Good service")
                .build();

        assertNotNull(review.toString());


    }

}