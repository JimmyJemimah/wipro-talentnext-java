import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryStr = scanner.next();

        try {
            int decimal = Integer.parseInt(binaryStr, 2);
            System.out.println("Decimal equivalent: " + decimal);
        } catch (NumberFormatException e) {
            System.out.println("Invalid binary number!");
        }

        scanner.close();
    }
}