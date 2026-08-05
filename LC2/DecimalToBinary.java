import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal integer: ");
        int number = scanner.nextInt();

        if (number == 0) {
            System.out.println("Binary representation: 0");
        } else {
            String binary = Integer.toBinaryString(number);
            System.out.println("Binary representation: " + binary);
        }

        scanner.close();
    }
}