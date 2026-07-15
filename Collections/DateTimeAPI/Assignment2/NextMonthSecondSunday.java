package Assignment2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class NextMonthSecondSunday {
    public static void main(String[] args) {
        // Get first day of next month
        LocalDate nextMonthFirstDay = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        
        // Find the first Sunday of next month
        LocalDate firstSunday = nextMonthFirstDay.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        
        // Add 7 days to get the second Sunday
        LocalDate secondSunday = firstSunday.plusWeeks(1);

        System.out.println("The date of next month's second Sunday is: " + secondSunday);
    }
}