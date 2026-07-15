package Assignment4;

import java.time.LocalDate;

public class LeapYearChecker {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        boolean isLeap = today.isLeapYear();

        System.out.println("Current Year: " + today.getYear());
        System.out.println("Is it a leap year? " + (isLeap ? "Yes" : "No"));
    }
}