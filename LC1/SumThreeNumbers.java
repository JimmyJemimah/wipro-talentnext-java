import java.util.Scanner;

public class SumThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.print("Enter third number: ");
        double num3 = scanner.nextDouble();

        double totalSum = num1 + num2 + num3;

        System.out.println("\nThe sum of the three numbers is: " + totalSum);
        scanner.close();
    }
}