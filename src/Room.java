import java.math.BigDecimal;

public class Room {
    private int number;
    private int capacity;
    private boolean balcony;
    private boolean seaView;
    private BigDecimal price;

    public Room(int number, int capacity, boolean balcony, boolean seaView, BigDecimal price) {
        this.number = number;
        this.capacity = capacity;
        this.balcony = balcony;
        this.seaView = seaView;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room: " + number + ", " + capacity + ", " + balcony + ", " + seaView + ", " + price;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
