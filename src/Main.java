import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        // Guests -->
        Guest guestFirst = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guestSecond = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));

        guestSecond.setBirthDate(LocalDate.of(1995, 4, 5));

        System.out.println("---> Required format + changed birthDate by Jan");
        System.out.println(guestFirst);
        System.out.println(guestSecond);

        // Rooms -->
        Room roomOne = new Room(1, 1,true, true, 1000);
        Room roomTwo = new Room(2, 1,true, true, 1000);
        Room roomThree = new Room(3, 3,false, true, 2400);

        System.out.println("---> Rooms properties");
        System.out.println(roomOne);
        System.out.println(roomTwo);
        System.out.println(roomThree);

        // Booking -->
        BookingManager bookingManager = new BookingManager();

        List<Guest> firstOrder = new ArrayList<>();
        firstOrder.add(guestFirst);
        Booking bookingFirstOrder = new Booking(roomOne, firstOrder, LocalDate.of(2021, 7,19), LocalDate.of(2021,7,26), "Work");
        bookingManager.addBooking(bookingFirstOrder);

        List<Guest> secondOrder = new ArrayList<>();
        secondOrder.add(guestFirst);
        secondOrder.add(guestSecond);
        Booking bookingSecondOrder = new Booking(roomThree, secondOrder, LocalDate.of(2021, 9,1), LocalDate.of(2021,9,14), "Joy");
        bookingManager.addBooking(bookingSecondOrder);

        // Booking manager -->
        System.out.println("---> All bookings");
        bookingManager.printAllBookings();

        // Date transformation Guest birthday
        System.out.println("---> Local date transformation");

        LocalDateTransform dateTransformGuestFirst = new LocalDateTransform(guestFirst.getBirthDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDateTransform dateTransformGuestSecond = new LocalDateTransform(guestSecond.getBirthDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Adéla birthday transformation to our type: " + dateTransformGuestFirst.getFormattedDate());
        System.out.println("Jan birthday transformation to our type: " + dateTransformGuestSecond.getFormattedDate());

        // Date transformation Room reservation
        System.out.println("---> Room reservation transformation");

        LocalDateTransform dateTransformReservationFromRoomOne = new LocalDateTransform(bookingFirstOrder.getFromDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDateTransform dateTransformReservationToRoomOne = new LocalDateTransform(bookingFirstOrder.getToDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        LocalDateTransform dateTransformReservationFromRoomTwo = new LocalDateTransform(bookingSecondOrder.getFromDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDateTransform dateTransformReservationToRoomTwo = new LocalDateTransform(bookingSecondOrder.getToDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));


        System.out.println("Room One reservation for Adéla: " + dateTransformReservationFromRoomOne.getFormattedDate() + " - " + dateTransformReservationToRoomOne.getFormattedDate());
        System.out.println("Room Three reservation for Adéla and Jan: " + dateTransformReservationFromRoomTwo.getFormattedDate() + " - " + dateTransformReservationToRoomTwo.getFormattedDate());


        //System.out.println("Adéla's reservation date: " + dateTransformGReservationFromGuestFirstFrom.getFormattedDate() + " - " + dateTransformGReservationFromGuestFirstTo.getFormattedDate());


    }

}