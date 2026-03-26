package za.ac.cput.repository;

import za.ac.cput.domain.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
    private final List<Booking> bookings = new ArrayList<>();

    // CREATE
    public Booking save(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }

        // prevent duplicates by ID (basic validation)
        if (findById(booking.getBookingId()) != null) {
            throw new IllegalStateException("Booking with ID already exists");
        }

        bookings.add(booking);
        return booking;
    }

    //READ (find by ID)
    public Booking findById(String bookingId) {
        if (bookingId == null) {
            return null;
        }

        for (Booking booking : bookings) {
            if (bookingId.equals(booking.getBookingId())) {
                return booking;
            }
        }
        return null;
    }

    //  READ (get all)
    public List<Booking> getAll() {
        // return a copy to protect internal list (encapsulation)
        return new ArrayList<>(bookings);
    }

    // DELETE
    public boolean delete(String bookingId) {
        Booking booking = findById(bookingId);
        if (booking != null) {
            bookings.remove(booking);
            return true;
        }
        return false;
    }
}
