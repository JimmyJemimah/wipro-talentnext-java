import java.util.Scanner;

public class DisplayDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int N = scanner.nextInt();

        // Convert to string or reverse to print digits in original left-to-right order
        String numStr = String.valueOf(Math.abs(N));
        System.out.print("Digits: ");
        for (int i = 0; i < numStr.length(); i++) {
            System.out.print(numStr.charAt(i) + (i < numStr.length() - 1 ? ", " : ""));
        }
        System.out.println();
        scanner.close();
    }
}