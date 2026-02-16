public class Ticket {
    private Screening screening;
    private Room room;
    private Seat seat;
    private Client client; // może być null (zakup bez konta)

    public Ticket(Screening screening, Room room, Seat seat, Client client) {
        this.screening = screening;
        this.room = room;
        this.seat = seat;
        this.client = client;
    }

    public Screening getScreening() {
        return screening;
    }

    public Room getRoom() {
        return room;
    }

    public Seat getSeat() {
        return seat;
    }

    public Client getClient() {
        return client;
    }

    public String getInfo() {
        String info = screening.getMovie().getTitle()
                + " | " + screening.getDateTime()
                + " | " + room
                + " | seat: " + seat;

        if (client != null) {
            info += " | client: " + client.getFullName();
        }

        return info;
    }


    }

