import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Full_Moon {
    public static void main(String args[]) {
        boolean loop = true;
        // Get the current date
        LocalDateTime today = LocalDateTime.now();

        // Reference full moon date
        LocalDateTime refMoon = LocalDateTime.of(2018, 1, 1, 19, 25);

        LocalDateTime prevMoon = refMoon;
        LocalDateTime nextMoon = refMoon;

        // Get the date for the next full moon, 29 days, 12 hours, 44 minutes from last full moon
        do {
            nextMoon = nextMoon.plusDays(29);
            nextMoon = nextMoon.plusHours(12);
            nextMoon = nextMoon.plusMinutes(44);

            // If the next moon is after todays date then exit the loop
            if (nextMoon.isAfter(today)) {
                prevMoon = nextMoon.minusDays(29);
                prevMoon = prevMoon.minusHours(12);
                prevMoon = prevMoon.minusMinutes(44);
                loop = false;
            }
        } while (loop == true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mma");

        System.out.println("Today's date is: " + today.format(formatter));
        System.out.println("The last full moon was: " + prevMoon.format(formatter));
        System.out.println("The next full moon is: " + nextMoon.format(formatter));


    }
}
