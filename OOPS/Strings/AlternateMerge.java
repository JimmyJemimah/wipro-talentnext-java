import java.util.Scanner;

public class AlternateMerge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String a = sc.next();

        System.out.print("Enter second string: ");
        String b = sc.next();

        String result = "";
        int max = Math.max(a.length(), b.length());

        for (int i = 0; i < max; i++) {
            if (i < a.length())
                result += a.charAt(i);

            if (i < b.length())
                result += b.charAt(i);
        }

        System.out.println(result);

        sc.close();
    }
}