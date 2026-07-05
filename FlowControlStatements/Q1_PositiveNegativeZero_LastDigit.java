public class Q1_PositiveNegativeZero_LastDigit {

    public static void main(String[] args) {

        // Part A
        int num = Integer.parseInt(args[0]);

        if (num > 0)
            System.out.println("Positive");
        else if (num < 0)
            System.out.println("Negative");
        else
            System.out.println("Zero");

        // Part B
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        if (a % 10 == b % 10)
            System.out.println("true");
        else
            System.out.println("false");
    }
}