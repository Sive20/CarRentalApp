package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {

    @Test
        public void testCreateBooking() {

            BookingRepository repository = new BookingRepository();

            Payment payment = new Payment();

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

            Booking saved = repository.save(booking);

            assertNotNull(saved);
            assertEquals("BAA234-565", saved.getBookingId());
        }

        @Test
        public void testFindById() {

            BookingRepository repository = new BookingRepository();

            Payment payment = new Payment();

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

            repository.save(booking);

            Booking found = repository.findById("BAA234-565");

            assertNotNull(found);
            assertEquals("OP34456451", found.getCustomerId());
        }

        @Test
        public void testGetAll() {

            BookingRepository repository = new BookingRepository();

            Payment payment = new Payment();

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

            repository.save(booking);

            List<Booking> bookings = repository.getAll();

            assertFalse(bookings.isEmpty());
            assertEquals(1, bookings.size());
        }

        @Test
        public void testDelete() {

            BookingRepository repository = new BookingRepository();

            Payment payment = new Payment();

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

            repository.save(booking);

            boolean deleted = repository.delete("BAA234-565");

            assertTrue(deleted);
            assertNull(repository.findById("BAA234-565"));
        }

        @Test
        public void testDuplicateBooking() {

            BookingRepository repository = new BookingRepository();

            Payment payment = new Payment();

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

            repository.save(booking);

            Exception exception = assertThrows(IllegalStateException.class, () -> {
                repository.save(booking);
            });

            assertEquals("Booking with ID already exists", exception.getMessage());
        }
    }

