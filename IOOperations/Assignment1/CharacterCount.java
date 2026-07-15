package Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name");
        String fileName = scanner.nextLine();

        System.out.println("Enter the character to be counted");
        String charInput = scanner.nextLine();

        if (charInput.isEmpty()) {
            System.out.println("No character entered.");
            scanner.close();
            return;
        }

        // Extract the targeted character and normalize to lowercase for case insensitivity
        char targetChar = Character.toLowerCase(charInput.charAt(0));
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int characterVal;
            while ((characterVal = reader.read()) != -1) {
                if (Character.toLowerCase((char) characterVal) == targetChar) {
                    count++;
                }
            }
            System.out.println("File '" + fileName + "' has " + count + " instances of letter '" + charInput.charAt(0) + "'.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}