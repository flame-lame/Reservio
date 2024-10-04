import java.time.LocalDate;
import java.util.List;

public class Booking {
    private Room room;
    private List<Guest> guests;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String typeOfVacation;

    public Booking(Room room, List<Guest> guests, LocalDate fromDate, LocalDate toDate, String typeOfVacation) {
        this.room = room;
        this.guests = guests;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.typeOfVacation = typeOfVacation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room number: ")
                .append(room.getNumber())
                .append(" From: ")
                .append(fromDate)
                .append(" To: ")
                .append(toDate)
                .append(" Guests: ");
        for (Guest guest : guests) {
            sb.append(guest.toString())
                    .append(", ");
        }
        sb.append("Type of Vacation: ")
                .append(typeOfVacation);
        return sb.toString();
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }
}
