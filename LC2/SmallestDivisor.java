import java.util.Scanner;

public class SmallestDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int smallestDivisor = number;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                smallestDivisor = i;
                break;
            }
        }

        System.out.println("Smallest divisor other than 1 is: " + smallestDivisor);
        scanner.close();
    }
}