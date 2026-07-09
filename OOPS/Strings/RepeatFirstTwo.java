import java.util.Scanner;

public class RepeatFirstTwo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        String firstTwo;

        if (str.length() < 2)
            firstTwo = str;
        else
            firstTwo = str.substring(0, 2);

        String result = "";

        for (int i = 0; i < str.length(); i++)
            result += firstTwo;

        System.out.println(result);

        sc.close();
    }
}