import java.util.Scanner;

public class TopThreeMinMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[20];

        System.out.println("Enter 20 integers:");
        for (int i = 0; i < 20; i++) {
            arr[i] = scanner.nextInt();
        }

        // Initialize top 3 max
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        // Initialize top 3 min
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;

        for (int num : arr) {
            // Find Top 3 Max
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            // Find Top 3 Min
            if (num < min1) {
                min3 = min2;
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min3 = min2;
                min2 = num;
            } else if (num < min3) {
                min3 = num;
            }
        }

        System.out.println("Maximum 3 elements: " + max1 + ", " + max2 + ", " + max3);
        System.out.println("Minimum 3 elements: " + min1 + ", " + min2 + ", " + min3);
        scanner.close();
    }
}