import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HomeWork17Task1 {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Europe/Minsk");
        ZonedDateTime firstLessonWed = ZonedDateTime.of(2022,10, 19, 18,30, 0, 0, zone);
        ZonedDateTime firstLessonSat = ZonedDateTime.of(2022,10, 22, 9,30, 0, 0, zone);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy HH:mm, VV");

        int weekNumber = 0;
        System.out.println("== Timetable ==");

        for (int lessonNumber = 1; lessonNumber <= 24; lessonNumber++) {
            if ((lessonNumber & 1) == 1) {
                ZonedDateTime currentLessonWed = firstLessonWed.plusWeeks(weekNumber);
                System.out.println("Lesson # " + lessonNumber + ": " + dateFormatter.format(currentLessonWed));
            } else {
                ZonedDateTime currentLessonSat = firstLessonSat.plusWeeks(weekNumber);
                System.out.println("Lesson # " + lessonNumber + ": " + dateFormatter.format(currentLessonSat));
                weekNumber++;
            }
        }
    }
}