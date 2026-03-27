package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    //  VALID TEST
    @Test
    void testCreateBookingSuccess() {

        Payment payment = new Payment();

        Booking booking = BookingFactory.createBooking(
                "BAA234-565",
                "OP34456451",
                "Car635",
                LocalDate.now(),
                LocalTime.of(9, 0),
                LocalTime.of(16, 0),
                8000.0,
                payment
        );

        assertNotNull(booking);
        assertEquals("BAA234-565", booking.getBookingId());
        assertEquals("OP34456451", booking.getCustomerId());
        assertEquals("Car635", booking.getCarId());
        assertEquals(8000.0, booking.getPrice());
        assertEquals(payment, booking.getPayment());
    }

    //  NULL IDs TEST
    @Test
    void testCreateBookingWithNullIds() {

        Payment payment = new Payment();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking(
                    null,
                    "OP34456459",
                    "CAR3",
                    LocalDate.now(),
                    LocalTime.of(9, 0),
                    LocalTime.of(16, 0),
                    8000.0,
                    payment
            );
        });

        assertEquals("IDs cannot be null", exception.getMessage());
    }

    //  NEGATIVE PRICE TEST
    @Test
    void testCreateBookingWithNegativePrice() {

        Payment payment = new Payment();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.createBooking(
                    "CAA234-565",
                    "OP34456459",
                    "Car3",
                    LocalDate.now(),
                    LocalTime.of(9, 0),
                    LocalTime.of(16, 0),
                    -300.0,
                    payment
            );
        });

        assertEquals("Price cannot be negative", exception.getMessage());
    }

}