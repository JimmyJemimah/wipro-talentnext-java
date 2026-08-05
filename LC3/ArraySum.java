
import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        int sum = 0;

        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        System.out.println("The sum of all elements is: " + sum);
        scanner.close();
    }
}