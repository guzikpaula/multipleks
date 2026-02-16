import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String surname;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public Client(int id, String name, String surname) {
        this .id = id;
        this.name = name;
        this.surname = surname;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addReservation (Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return name + " " + surname;
    }
}
