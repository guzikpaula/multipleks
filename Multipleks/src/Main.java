import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cinema cinema1 = new Cinema("Kino ARS", "ul. Jana 5", "Kraków");

        Movie movie1 = new Movie("Wichrowe Wzgórza", 130);
        Movie movie2 = new Movie("Hamnet", 140);

        Room room1 = new Room(1);
        Seat r1s1 = new Seat("A", 1);
        Seat r1s2 = new Seat("A", 2);
        Seat r1s3 = new Seat("A", 3);
        Seat r1s4 = new Seat("A", 4);
        room1.addSeat(r1s1);
        room1.addSeat(r1s2);
        room1.addSeat(r1s3);
        room1.addSeat(r1s4);

        Screening screening1_1 = new Screening(
                movie1,
                LocalDateTime.of(2026,2,20,18,30),
                ScreeningType.THREE_D,
                room1
        );

                Screening screening1_2 = new Screening(
                movie2,
                        LocalDateTime.of(2026,2,22,18,30),
                ScreeningType.NORMAL,
                room1
        );

        cinema1.getProgramme().addScreening(screening1_1);
        cinema1.getProgramme().addScreening(screening1_2);

        System.out.println("Programme for next 7 days in \"" + cinema1.getName() + "\":");
        cinema1.getProgramme().printProgrammeForNextWeek();
        System.out.println("==========================");

        Cinema cinema2 = new Cinema("Kino Pod Baranami", "ul. Rynek Główny 24", "Kraków");

        Movie movie2_1 = new Movie("La Grazia", 110);
        Movie movie2_2 = new Movie("Wielki Marty", 140);

        Room room2 = new Room(2);
        Seat r2s1 = new Seat("B", 1);
        Seat r2s2 = new Seat("B", 2);
        Seat r2s3 = new Seat("B", 3);
        Seat r2s4 = new Seat("B", 4);
        room2.addSeat(r2s1);
        room2.addSeat(r2s2);
        room2.addSeat(r2s3);
        room2.addSeat(r2s4);

        Screening screening2_1 = new Screening(
                movie2_1,
                LocalDateTime.of(2026,2,25,17,30),
                ScreeningType.VIP,
                room2
        );

        Screening screening2_2 = new Screening(
                movie2_2,
                LocalDateTime.of(2026,2,21,19,30),
                ScreeningType.NORMAL,
                room2
        );

        cinema2.getProgramme().addScreening(screening2_1);
        cinema2.getProgramme().addScreening(screening2_2);

        //System.out.println("==========================");
        System.out.println("Programme for next 7 days in \"" + cinema2.getName() + "\":");
        cinema2.getProgramme().printProgrammeForNextWeek();

        //Zakup przez klientów
        Client client1 = new Client(1, "Jan", "Gołąb");
        Client client2 = new Client(2, "Piotr", "Michalski");
        screening2_2.buyTickets(client1, room2, r2s2);
        screening2_2.buyTickets(client2, room2, r2s1);


        System.out.println("==========================");
        System.out.println("Tickets with client account:");

        System.out.println("Client: " + client1.getFullName());
        for (Ticket t : client1.getTickets()) {
            System.out.println(t.getInfo());
        }

        System.out.println("--------------------------");

        System.out.println("Client: " + client2.getFullName());
        for (Ticket t : client2.getTickets()) {
            System.out.println(t.getInfo());
        }

        // Zakup bez konta
        screening1_2.buyTickets(room1, r1s1);
        screening2_1.buyTickets(room2, r2s1);

        List<Ticket> ticketsWithoutClient1 = screening1_2.buyTickets(room1, r1s2);
        List<Ticket> ticketsWithoutClient2 = screening1_1.buyTickets(room1, r1s4);

        System.out.println("==========================");
        System.out.println("Tickets without client account:");
        for (Ticket t : ticketsWithoutClient1) {
            System.out.println(t.getInfo());
        }
        for (Ticket t : ticketsWithoutClient2) {
            System.out.println(t.getInfo());
        }

        System.out.println("==========================");
        System.out.println("Seats reservations:");
        screening1_2.reservePlaces(room1, r1s3);
        screening1_2.reservePlaces(client2, room1, r1s4);
        screening1_2.printReservations();

        System.out.println("==========================");
        System.out.println( cinema1.getName() + " : ");
        System.out.println("Free seats for " + screening1_1.getMovie().getTitle() + ": " + screening1_1.getFreeSeats());
        System.out.println("Free seats for " + screening1_2.getMovie().getTitle() + ": " + screening1_2.getFreeSeats());
        System.out.println( cinema2.getName() + " : ");
        System.out.println("Free seats for " + screening2_1.getMovie().getTitle() + ": " + screening2_1.getFreeSeats());
        System.out.println("Free seats for " + screening2_2.getMovie().getTitle() + ": " + screening2_2.getFreeSeats());
    }
}
