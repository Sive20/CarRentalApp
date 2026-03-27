package za.ac.cput.domain;

public class Review {
    private String reviewId;
    private String customerId;
    private String carId;
    private int rating;
    private String comment;

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.customerId = builder.customerId;
        this.carId = builder.carId;
        this.rating = builder.rating;
        this.comment = builder.comment;
    }

    public String getReviewId() {

        return reviewId;
    }

    public String getCustomerId() {

        return customerId;
    }

    public String getCarId() {

        return carId;
    }

    public int getRating() {

        return rating;
    }

    public String getComment() {

        return comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", carId='" + carId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }

    public static class Builder {

        private String reviewId;
        private String customerId;
        private String carId;
        private int rating;
        private String comment;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setCarId(String carId) {
            this.carId = carId;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
