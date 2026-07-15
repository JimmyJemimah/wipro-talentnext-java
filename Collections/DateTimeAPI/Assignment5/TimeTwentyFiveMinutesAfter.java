package Assignment5;

import java.time.LocalTime;

public class TimeTwentyFiveMinutesAfter {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        LocalTime laterTime = currentTime.plusMinutes(25);

        System.out.println("Current Time: " + currentTime);
        System.out.println("Time after 25 minutes: " + laterTime);
    }
}