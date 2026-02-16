import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Screening {
    private Movie movie;
    private LocalDateTime dateTime;
    private ScreeningType type;
    private Room room;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public Screening(Movie movie, LocalDateTime dateTime, ScreeningType type, Room room) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.type = type;
        this.room = room;
    }

    public List<Seat> getFreeSeats() {
        List<Seat> free = new ArrayList<>(room.getSeats());

        for (Reservation r : reservations) {
            free.remove(r.getSeat());
        }
        for (Ticket t : tickets) {
            free.remove(t.getSeat());
        }
        return free;
    }

    public List <Seat> reservePlaces (Room room, Seat ... seats) {
        return reservePlaces(null, room, seats);
    }

    public List <Seat> reservePlaces (Client client, Room room, Seat ... seats) {
        List<Seat> reserved = new ArrayList<>();

        for (Seat seat : seats) {
            if (!getFreeSeats().contains(seat)) {
                throw new IllegalArgumentException("Seat " + seat + " is already taken");
            }

            Reservation reservation = new Reservation(this, room, seat, client);
            reservations.add(reservation);
            reserved.add(seat);

            if (client != null) {
                client.addReservation(reservation);
            }
        }

        return reserved;
    }

    public void printReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations.");
            return;
        }

        for (Reservation r : reservations) {
            System.out.println(r.getInfo());
        }
    }


    // zakup bez konta
    public List<Ticket> buyTickets(Room room, Seat... seats) {
        return buyTickets(null, room, seats);
    }

    // zakup z kontem
    public List<Ticket> buyTickets(Client client, Room room, Seat... seats) {
        List<Ticket> bought = new ArrayList<>();

        for (Seat seat : seats) {
            if (!getFreeSeats().contains(seat)) {
                throw new IllegalArgumentException("Seat " + seat + " is already taken");
            }

            Ticket ticket = new Ticket(this, room, seat, client);
            tickets.add(ticket);
            bought.add(ticket);

            if (client != null) {
                client.addTicket(ticket);
            }
        }

        return bought;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ScreeningType getType() {
        return type;
    }

    public String getInfo() {
        return movie.getTitle() + " | " + dateTime + " | " + type;
    }
}
