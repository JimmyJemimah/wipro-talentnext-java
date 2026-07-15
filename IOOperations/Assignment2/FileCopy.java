package Assignment2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the input file name");
        String inputFileName = scanner.nextLine();

        System.out.println("Enter the output file name");
        String outputFileName = scanner.nextLine();

        try (FileReader reader = new FileReader(inputFileName);
             FileWriter writer = new FileWriter(outputFileName)) {
            
            int characterVal;
            while ((characterVal = reader.read()) != -1) {
                writer.write(characterVal);
            }
            System.out.println("File is copied.");
            
        } catch (IOException e) {
            System.out.println("Error processing file copying: " + e.getMessage());
        }

        scanner.close();
    }
}