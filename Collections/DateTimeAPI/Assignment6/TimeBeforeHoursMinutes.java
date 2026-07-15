package Assignment6;

import java.time.LocalTime;

public class TimeBeforeHoursMinutes {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        LocalTime earlierTime = currentTime.minusHours(5).minusMinutes(30);

        System.out.println("Current Time: " + currentTime);
        System.out.println("Time before 5 hours and 30 minutes: " + earlierTime);
    }
}