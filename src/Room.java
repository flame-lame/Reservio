import java.math.BigDecimal;

public class Room {
    private int number;
    private int capacity;
    private boolean balcony;
    private boolean seaView;
    private double price;

    public Room(int number, int capacity, boolean balcony, boolean seaView, double price) {
        this.number = number;
        this.capacity = capacity;
        this.balcony = balcony;
        this.seaView = seaView;
        this.price = price;
    }

    @Override
    public String toString() {
        return "No. " + number + ", Capacity: " + capacity + ", Balcony: " + balcony + ", Sea view: " + seaView + ", Price per night (CZK): " + price;
    }

    public int getNumber() {
        return number;
    }

}
