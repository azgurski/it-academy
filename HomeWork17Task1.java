import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HomeWork17Task1 {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Europe/Minsk");
        DateTimeFormatter dayNameDayMonthYearHrsMnZone = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy HH:mm, VV");

        LocalDateTime firstLessonWedLocal = LocalDateTime.of(2022, 10, 19, 18, 30);
        ZonedDateTime firstWed = ZonedDateTime.of(firstLessonWedLocal, zone);

        LocalDateTime firstLessonSatLocal = LocalDateTime.of(2022, 10, 22, 9, 30);
        ZonedDateTime firstSat = ZonedDateTime.of(firstLessonSatLocal, zone);

        int weekNumber = 0;
        System.out.println("== Timetable ==");

        for (int lessonNumber = 1; lessonNumber <= 24; lessonNumber++) {
            if ((lessonNumber & 1) == 1) {
                ZonedDateTime newWed = firstWed.plusWeeks(weekNumber * 1);
                System.out.println("Lesson # " + lessonNumber + ": " + dayNameDayMonthYearHrsMnZone.format(newWed));
            } else {
                ZonedDateTime newSat = firstSat.plusWeeks(weekNumber * 1);
                System.out.println("Lesson # " + lessonNumber + ": " + dayNameDayMonthYearHrsMnZone.format(newSat));
                weekNumber++;
            }
        }
    }
}