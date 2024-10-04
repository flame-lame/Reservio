import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void printAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

}
