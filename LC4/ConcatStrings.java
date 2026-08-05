import java.util.Scanner;

public class ConcatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string1: ");
        String string1 = scanner.nextLine();

        System.out.print("Enter string2: ");
        String string2 = scanner.nextLine();

        String string3 = string1 + string2;

        System.out.println("string3: " + string3);
        scanner.close();
    }
}