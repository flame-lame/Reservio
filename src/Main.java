import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        Guest guestFirst = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guestSecond = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));

        Room roomOne = new Room(1, 1, true, true, new BigDecimal("1000.00"));
        Room roomTwo = new Room(2, 1, true, true, new BigDecimal("1000.00"));
        Room roomThree = new Room(3, 3, false, true, new BigDecimal("2400.00"));

        Booking reservationOne = new Booking(1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26));
        Booking reservationTwo = new Booking(2, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14));

        guestSecond.setBirthDate(LocalDate.of(1995, 4, 5));

        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guestFirst);
        guests.add(guestSecond);

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(roomOne);
        rooms.add(roomTwo);
        rooms.add(roomThree);

        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(reservationOne);
        bookings.add(reservationTwo);

        System.out.println("---> Guests");
        for (Guest guest : guests) {
            System.out.println(guest.getName() + " " + guest.getSurname() + " (" + guest.getBirthDate() + ")");
        }

        System.out.println("---> Room properties");
        for (Room room : rooms) {
            System.out.println("Room number: " + room.getNumber() + " # " + "Room capacity: " + room.getCapacity() + " # " + "Has balcony: " + room.isBalcony() + " # " + "Has sea view: " + room.isSeaView() + " # " + "Price per night (CZK): " + room.getPrice());
        }

        System.out.println("---> Bookings");
        for (Booking booking : bookings) {
            System.out.println("Booking number: " + booking.getBookingID() + " # " + "Date: " + booking.getBookingDateStart() + " - " + booking.getBookingDateEnd());
        }

        System.out.println("---> Reservation");
        System.out.println("Guests: " + guests.get(0).getName() + " " + guests.get(0).getSurname() + " # " + "Room number: " + rooms.get(0).getNumber() + " # " + "Starts: " + reservationOne.getBookingDateStart() + " Ends: " + reservationOne.getBookingDateEnd());
        System.out.println("Guests: " + guests.get(0).getName() + " " + guests.get(0).getSurname() + " & " + guests.get(1).getName() + " " + guests.get(1).getSurname() + " # " + "Room number: " + rooms.get(2).getNumber() + " # " + "Starts: " + reservationTwo.getBookingDateStart() + " Ends: " + reservationTwo.getBookingDateEnd());

    }
}