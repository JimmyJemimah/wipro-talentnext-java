import java.util.Scanner;

public class CountLessThanAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int sum = 0;

        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / 10;
        int count = 0;

        for (int i = 0; i < 10; i++) {
            if (numbers[i] < average) {
                count++;
            }
        }

        System.out.println("Average: " + average);
        System.out.println("Count of numbers less than average: " + count);
        scanner.close();
    }
}