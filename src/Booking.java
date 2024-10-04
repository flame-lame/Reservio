import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
    private int bookingID;
    private LocalDate bookingDateStart;
    private LocalDate bookingDateEnd;

    public Booking(int bookingID , LocalDate bookingDateStart, LocalDate bookingDateEnd) {
        this.bookingID = bookingID;
        this.bookingDateStart = bookingDateStart;
        this.bookingDateEnd = bookingDateEnd;
    }

    public int getBookingID() {
        return bookingID;
    }

    public LocalDate getBookingDateStart() {
        return bookingDateStart;
    }

    public LocalDate getBookingDateEnd() {
        return bookingDateEnd;
    }
}
