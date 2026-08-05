import java.util.Scanner;

public class FindNumberPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[15];

        System.out.println("Enter 15 integer elements:");
        for (int i = 0; i < 15; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the number X to search: ");
        int target = scanner.nextInt();

        boolean found = false;
        System.out.println("\nSearching for " + target + "...");

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                // Displaying 1-based position for user-friendly output
                System.out.println("Number " + target + " found at position: " + (i + 1) + " (Index: " + i + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Number " + target + " is not present in the array.");
        }

        scanner.close();
    }
}