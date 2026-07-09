import java.util.Scanner;

public class ConcatStrings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String a = sc.next();

        System.out.print("Enter second string: ");
        String b = sc.next();

        if (a.charAt(a.length() - 1) == b.charAt(0))
            System.out.println((a + b.substring(1)).toLowerCase());
        else
            System.out.println((a + b).toLowerCase());

        sc.close();
    }
}