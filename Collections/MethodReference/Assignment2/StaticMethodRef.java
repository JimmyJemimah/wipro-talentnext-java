package Assignment2;

// Custom Functional Interface
interface DigitCountInterface {
    int getCount(int n);
}

// Class containing the static method
class NumberUtility {
    public static int digitCount(int n) {
        // Handle negative numbers and zero properly
        return String.valueOf(Math.abs(n)).length();
    }
}

public class StaticMethodRef {
    public static void main(String[] args) {
        // Method reference to a static method
        DigitCountInterface countRef = NumberUtility::digitCount;

        // Invoke the method via the functional interface
        int input = 123456;
        System.out.println("Number of digits in " + input + " is: " + countRef.getCount(input));
    }
}