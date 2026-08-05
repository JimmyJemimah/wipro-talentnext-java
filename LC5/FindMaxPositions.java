import java.util.Scanner;

public class FindMaxPositions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[25];

        System.out.println("Enter 25 integer elements:");
        for (int i = 0; i < 25; i++) {
            array[i] = scanner.nextInt();
        }

        int maxVal = array[0];
        int firstPos = 0;
        int lastPos = 0;

        // First pass: Find maximum value
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        // Second pass: Find first and last positions (1-indexed)
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxVal) {
                if (firstPos == 0) {
                    firstPos = i + 1;
                }
                lastPos = i + 1;
            }
        }

        System.out.println("Maximum Value: " + maxVal);
        System.out.println("First Occurrence Position (1-indexed): " + firstPos);
        System.out.println("Last Occurrence Position (1-indexed): " + lastPos);

        scanner.close();
    }
}