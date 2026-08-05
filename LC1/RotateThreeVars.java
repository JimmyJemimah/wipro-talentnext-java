import java.util.Scanner;

public class RotateThreeVars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();
        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();
        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();

        System.out.println("\nBefore change: a = " + a + ", b = " + b + ", c = " + c);

        // Store original c before overwriting
        int temp = c;
        c = b;
        b = a;
        a = temp;

        System.out.println("After change:  a = " + a + ", b = " + b + ", c = " + c);
        scanner.close();
    }
}