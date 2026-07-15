package Assignment3;

import java.util.Scanner;

public class BinaryPadding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer number (between 1 and 255): ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            
            if (number >= 1 && number <= 255) {
                // Convert to binary string using Integer wrapper class method
                String binaryString = Integer.toBinaryString(number);
                
                // Format string to have 8 characters, padded with leading zeros
                String paddedBinaryString = String.format("%8s", binaryString).replace(' ', '0');
                
                System.out.println(paddedBinaryString);
            } else {
                System.out.println("Error: Number must be between 1 and 255.");
            }
        } else {
            System.out.println("Error: Invalid integer input.");
        }
        
        scanner.close();
    }
}