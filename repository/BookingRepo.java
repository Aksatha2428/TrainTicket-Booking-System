package repository;

import model.Booking;
import java.util.HashMap;

public class BookingRepo {

    private HashMap<Integer, Booking> bookings = new HashMap<>();

    public void save(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public Booking getBooking(int bookingId) {
        return bookings.get(bookingId);
    }

    public void remove(int bookingId) {
        bookings.remove(bookingId);
    }
}