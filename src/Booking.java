import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.lang.String;


public class Booking {
    private Room room;
    private List<Guest> guests;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String typeOfVacation;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Booking(Room room, List<Guest> guests, LocalDate fromDate, LocalDate toDate, String typeOfVacation) {
        this.room = room;
        this.guests = guests;
        this.typeOfVacation = typeOfVacation;

        if (fromDate == null || toDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        LocalDateTransform dateFrom = new LocalDateTransform(fromDate, formatter);
        LocalDateTransform dateTo = new LocalDateTransform(toDate, formatter);
        return "Room nmb:  " + room + ", Guests: " + guests + ", From: " + dateFrom.getFormattedDate() + ", To: " + dateTo.getFormattedDate() + ", Type of Vacation: " + typeOfVacation;
    }

}
