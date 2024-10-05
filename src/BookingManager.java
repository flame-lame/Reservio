import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();;

    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
        } else {
            System.out.println("Cannot add null booking.");
        }
    }

    public void printAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public boolean isAvailable(Room room, LocalDate fromDate, LocalDate toDate) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room) &&
                    !(toDate.isBefore(booking.getFromDate()) || fromDate.isAfter(booking.getToDate()))) {
                return false;
            }
        }
        return true;
    }

}
