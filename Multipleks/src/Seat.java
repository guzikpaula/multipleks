public class Seat {
    private String row;
    private int number;

    public Seat(String row, int number) {
        this.row = row;
        this.number = number;
    }

    public String getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return row + number;
    }
}