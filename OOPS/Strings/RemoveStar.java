import java.util.Scanner;

public class RemoveStar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        int index = str.indexOf('*');

        if (index != -1) {
            String result = str.substring(0, Math.max(0, index - 1))
                    + str.substring(Math.min(str.length(), index + 2));
            System.out.println(result);
        } else {
            System.out.println(str);
        }

        sc.close();
    }
}