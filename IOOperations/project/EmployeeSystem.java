package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeSystem {
    private static final String FILE_NAME = "EmployeeDetails.txt";
    // ... rest of your code stays exactly the same    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Main Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } else {
                System.out.println("Invalid entry. Please choose a number between 1 and 3.");
                scanner.nextLine(); // Clear invalid input
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting the System");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Employee Age: ");
        String age = scanner.nextLine();
        
        System.out.print("Enter Employee Salary: ");
        String salary = scanner.nextLine();

        try {
            double salVal = Double.parseDouble(salary);
            salary = String.valueOf(salVal);
        } catch (NumberFormatException e) {
            // Keep original string if it's not a parsable number
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(id + " " + name + " " + age + " " + salary);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving employee details: " + e.getMessage());
        }
    }

    private static void displayAllEmployees() {
        System.out.println("----Report-----");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean hasData = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasData = true;
            }
            if (!hasData) {
                System.out.println("No employee records found.");
            }
        } catch (IOException e) {
            System.out.println("No records found or error reading storage file.");
        }
        
        System.out.println("----End of Report-----");
    }
}