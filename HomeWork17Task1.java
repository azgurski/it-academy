import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HomeWork17Task1 {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Europe/Minsk");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy HH:mm, VV");

        LocalDateTime firstLessonWed = LocalDateTime.of(2022, 10, 19, 18, 30);
        ZonedDateTime firstWed = ZonedDateTime.of(firstLessonWed, zone);

        LocalDateTime firstLessonSat = LocalDateTime.of(2022, 10, 22, 9, 30);
        ZonedDateTime firstSat = ZonedDateTime.of(firstLessonSat, zone);

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