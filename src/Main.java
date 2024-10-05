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
        Guest guestThird = new Guest("Peter", "Voraj", LocalDate.of(1997, 2, 7));

        guestSecond.setBirthDate(LocalDate.of(1995, 4, 5));

        System.out.println("---> Transformed birth day + changed birthDate by Jan");

        LocalDateTransform birthDateGuestFirst = new LocalDateTransform(guestFirst.getBirthDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDateTransform birthDateGuestSecond = new LocalDateTransform(guestSecond.getBirthDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("First name: " + guestFirst.getName() + ", Last name: " + guestFirst.getSurname() + ", Date of birth: " + birthDateGuestFirst.getFormattedDate());
        System.out.println("First name: " + guestSecond.getName() + ", Last name: " + guestSecond.getSurname() + ", Date of birth: " + birthDateGuestSecond.getFormattedDate());

        // Rooms -->
        Room roomOne = new Room(1, 1,true, true, 1000);
        Room roomTwo = new Room(2, 1,true, true, 1000);
        Room roomThree = new Room(3, 3,false, true, 2400);

        System.out.println("---> Rooms properties");
        System.out.println(roomOne);
        System.out.println(roomTwo);
        System.out.println(roomThree);

        // Booking -->
        System.out.println("---> Booking with date control");

        BookingManager bookingManager = new BookingManager();

        List<Guest> firstOrder = new ArrayList<>();
        firstOrder.add(guestFirst);
        Booking bookingFirstOrder = new Booking(roomOne, firstOrder, LocalDate.of(2021, 7,19), LocalDate.of(2021,7,26), "Work");

        extracted(bookingManager, bookingFirstOrder, firstOrder);

        List<Guest> secondOrder = new ArrayList<>();
        secondOrder.add(guestFirst);
        secondOrder.add(guestSecond);
        Booking bookingSecondOrder = new Booking(roomThree, secondOrder, LocalDate.of(2020, 3,19), LocalDate.of(2020,3,26), "Adult tape");

        extracted1(bookingManager, bookingSecondOrder, secondOrder);

        List<Guest> thirdOrder = new ArrayList<>();
        thirdOrder.add(guestThird);
        Booking bookingThirdOrder = new Booking(roomThree, thirdOrder, LocalDate.of(2024, 3,19), LocalDate.of(2024,3,26), "Tourist");

        extract2(bookingManager, thirdOrder, bookingThirdOrder);

        // Booking manager -->
        System.out.println("---> All bookings");
        bookingManager.printAllBookings();
    }

    private static void extract2(BookingManager bookingManager, List<Guest> thirdOrder, Booking bookingThirdOrder) {
        if (bookingManager.isAvailable(bookingThirdOrder.getRoom(), bookingThirdOrder.getFromDate(), bookingThirdOrder.getToDate())) {
            LocalDateTransform thirdOrderFromDate = new LocalDateTransform(bookingThirdOrder.getFromDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDateTransform thirdOrderToDate = new LocalDateTransform(bookingThirdOrder.getToDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            bookingManager.addBooking(bookingThirdOrder);
            System.out.println("Enjoy your vacation! " + thirdOrder.getFirst() + " - " + thirdOrderFromDate.getFormattedDate() + " - " + thirdOrderToDate.getFormattedDate());
        } else {
            System.out.println("Its booked, please choose another dates.");
        }
    }

    private static void extracted1(BookingManager bookingManager, Booking bookingSecondOrder, List<Guest> secondOrder) {
        extract2(bookingManager, secondOrder, bookingSecondOrder);
    }

    private static void extracted(BookingManager bookingManager, Booking bookingFirstOrder, List<Guest> firstOrder) {
        extract2(bookingManager, firstOrder, bookingFirstOrder);
    }
}