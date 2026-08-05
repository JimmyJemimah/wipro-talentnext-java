import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value for X: ");
        int X = scanner.nextInt();
        System.out.print("Enter value for Y: ");
        int Y = scanner.nextInt();

        System.out.println("\nBefore Swap: X = " + X + ", Y = " + Y);

        // Swapping using a temporary variable T
        int T = Y;
        Y = X;
        X = T;

        System.out.println("After Swap:  X = " + X + ", Y = " + Y);
        scanner.close();
    }
}