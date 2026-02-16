public class Reservation {

    private Screening screening;
    private Room room;
    private Seat seat;
    private Client client; // może być null (rezerwacja bez konta)

    public Reservation(Screening screening, Room room, Seat seat, Client client) {
        this.screening = screening;
        this.room = room;
        this.seat = seat;
        this.client = client;
    }

    public Seat getSeat() {
        return seat;
    }


    public String getInfo() {
        if (client != null) {
            return "Reservation: " + screening.getMovie().getTitle() +
                    " | " + screening.getDateTime() +
                    " | " + room +
                    " | seat: " + seat +
                    " | client: " + client.getFullName();
        } else {
            return "Reservation: " + screening.getMovie().getTitle() +
                    " | " + screening.getDateTime() +
                    " | " + room +
                    " | seat: " + seat;
        }
    }
}
