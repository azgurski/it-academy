import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HomeWork17Task1 {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Europe/Minsk");
        ZonedDateTime firstWed = ZonedDateTime.of(2022,10, 19, 18,30, 0, 0, zone);
        ZonedDateTime firstSat = ZonedDateTime.of(2022,10, 22, 9,30, 0, 0, zone);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy HH:mm, VV");

        int weekNumber = 0;
        System.out.println("== Timetable ==");

        for (int lessonNumber = 1; lessonNumber <= 24; lessonNumber++) {
            if ((lessonNumber & 1) == 1) {
                ZonedDateTime newWed = firstWed.plusWeeks(weekNumber);
                System.out.println("Lesson # " + lessonNumber + ": " + dateFormatter.format(newWed));
            } else {
                ZonedDateTime newSat = firstSat.plusWeeks(weekNumber);
                System.out.println("Lesson # " + lessonNumber + ": " + dateFormatter.format(newSat));
                weekNumber++;
            }
        }
    }
}