import java.util.Scanner;

public class CountPosNeg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positiveCount = 0;
        int negativeCount = 0;

        System.out.println("Enter 5 numbers:");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Number " + i + ": ");
            double num = scanner.nextDouble();
            if (num >= 0) {
                positiveCount++;
            } else {
                negativeCount++;
            }
        }

        System.out.println("\nNon-negative numbers count (including 0): " + positiveCount);
        System.out.println("Negative numbers count: " + negativeCount);
        scanner.close();
    }
}