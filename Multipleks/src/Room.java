import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private List<Seat> seats = new ArrayList<>();

    public Room(int number) {
        this.number = number;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Room" + number;
    }
}
