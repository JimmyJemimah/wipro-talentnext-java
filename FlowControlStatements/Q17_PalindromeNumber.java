public class Q17_PalindromeNumber {
    public static void main(String[] args) {

        int num = Integer.parseInt(args[0]);
        int original = num;
        int reverse = 0;

        while (num != 0) {
            reverse = reverse * 10 + (num % 10);
            num = num / 10;
        }

        if (original == reverse)
            System.out.println(original + " is a palindrome");
        else
            System.out.println(original + " is not a palindrome");
    }
}