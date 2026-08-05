import java.util.Scanner;

public class MarksFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[30];
        int[] count = new int[101]; // Frequency array for marks 0 to 100

        System.out.println("Enter marks for 30 students (0 to 100):");
        for (int i = 0; i < 30; i++) {
            marks[i] = scanner.nextInt();
            if (marks[i] >= 0 && marks[i] <= 100) {
                count[marks[i]]++;
            }
        }

        System.out.println("\nMarks Frequency Count:");
        for (int i = 0; i <= 100; i++) {
            if (count[i] > 0) {
                System.out.println("Mark " + i + ": " + count[i] + " student(s)");
            }
        }

        scanner.close();
    }
}