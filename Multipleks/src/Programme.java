import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Programme {
    private List<Screening> screenings = new ArrayList<>();

    public void printProgrammeForNextWeek() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime weekLater = now.plusDays(7);

        for (Screening s : screenings) {
            if (!s.getDateTime().isBefore(now) &&
                    !s.getDateTime().isAfter(weekLater)) {

                System.out.println(s.getInfo());
            }
        }
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public List<Screening> getScreenings() {
        return screenings;
    }
}
