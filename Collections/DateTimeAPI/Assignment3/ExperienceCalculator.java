package Assignment3;

import java.time.LocalDate;
import java.time.Period;

public class ExperienceCalculator {
    public static void main(String[] args) {
        // Example joining date (Replace with your actual joining date if needed)
        LocalDate joiningDate = LocalDate.of(2023, 5, 15); 
        LocalDate currentDate = LocalDate.now();

        Period experience = Period.between(joiningDate, currentDate);

        System.out.println("Wipro Experience details:");
        System.out.println("Years: " + experience.getYears());
        System.out.println("Months: " + experience.getMonths());
        System.out.println("Days: " + experience.getDays());
    }
}