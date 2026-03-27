package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private String bookingId;
    private String customerId;
    private String carId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double price;
    private Payment payment;

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.customerId = builder.customerId;
        this.carId = builder.carId;
        this.date = builder.date;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.price = builder.price;
        this.payment = builder.payment;
    }

    public String getBookingId() {

        return bookingId;
    }

    public String getCustomerId() {

        return customerId;
    }

    public String getCarId() {

        return carId;
    }

    public LocalDate getDate() {

        return date;
    }

    public LocalTime getStartTime() {

        return startTime;
    }

    public LocalTime getEndTime() {

        return endTime;
    }

    public double getPrice() {

        return price;
    }

    public Payment getPayment() {

        return payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", carId='" + carId + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", payment=" + payment +
                '}';
    }

    public static class Builder {

        private String bookingId;
        private String customerId;
        private String carId;
        private LocalDate date;
        private LocalTime startTime;
        private LocalTime endTime;
        private double price;
        private Payment payment;

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
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

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
