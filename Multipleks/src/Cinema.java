public class Cinema {
    private String name;
    private String street;
    private String city;
    private Programme programme = new Programme();

    public Cinema(String name, String street, String city) {
        this.name = name;
        this.street = street;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void printProgramme() {
        for (Screening s : programme.getScreenings()) {
            System.out.println(
                    s.getMovie().getTitle() + " | " +
                            s.getDateTime() + " | " +
                            s.getType()
            );
        }
    }
}

