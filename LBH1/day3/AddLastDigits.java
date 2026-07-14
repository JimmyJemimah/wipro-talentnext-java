public class AddLastDigits {

    public static int addLastDigits(int input1, int input2) {

        int lastDigit1 = Math.abs(input1 % 10);
        int lastDigit2 = Math.abs(input2 % 10);

        return lastDigit1 + lastDigit2;
    }

    public static void main(String[] args) {
        System.out.println(addLastDigits(267, 154));
        System.out.println(addLastDigits(267, -154));
        System.out.println(addLastDigits(-267, 154));
        System.out.println(addLastDigits(-267, -154));
    }
}