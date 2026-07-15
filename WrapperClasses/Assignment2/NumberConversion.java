package Assignment2;

public class NumberConversion {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide an integer number as a command line argument.");
            return;
        }

        try {
            int inputNumber = Integer.parseInt(args[0]);

            System.out.println("Given Number :" + inputNumber);
            System.out.println("Binary equivalent :" + Integer.toBinaryString(inputNumber));
            System.out.println("Octal equivalent :" + Integer.toOctalString(inputNumber));
            System.out.println("Hexadecimal equivalent :" + Integer.toHexString(inputNumber));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide a valid integer.");
        }
    }
}