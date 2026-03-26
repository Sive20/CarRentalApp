package za.ac.cput.domain;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

class BookingTest {

    @Test
    public void testCreateBooking() {

        // Create Payment
        Payment payment = new Payment();

        // Create Booking using Builder
        Booking booking = new Booking.Builder()
                .setBookingId("BAA234-565")
                .setCustomerId("OP34456451")
                .setCarId("Car635")
                .setDate(LocalDate.now())
                .setStartTime(LocalTime.of(9, 0))
                .setEndTime(LocalTime.of(16, 0))
                .setPrice(8000.0)
                .setPayment(payment)
                .build();

        //  Assertions
        assertNotNull(booking);
        assertEquals("BAA234-565", booking.getBookingId());
        assertEquals("OP34456451", booking.getCustomerId());
        assertEquals("Car635", booking.getCarId());
        assertEquals(8000.0, booking.getPrice());
        assertEquals(payment, booking.getPayment());
    }

    }
