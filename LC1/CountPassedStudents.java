import java.util.Scanner;

public class CountPassedStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passedCount = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter mark for student " + i + " (0-100): ");
            double mark = scanner.nextDouble();
            if (mark >= 35) {
                passedCount++;
            }
        }

        System.out.println("\nNumber of students passed: " + passedCount);
        scanner.close();
    }
}