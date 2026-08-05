import java.util.Scanner;

public class CheckEvenOddZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (num == 0) {
            System.out.println("The number is Zero.");
        } else if (num % 2 == 0) {
            System.out.println("The number is Even.");
        } else {
            System.out.println("The number is Odd.");
        }

        scanner.close();
    }
}